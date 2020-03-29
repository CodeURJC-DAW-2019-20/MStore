import {HttpEvent,HttpHandler,HttpRequest,HttpErrorResponse,HttpInterceptor} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(retry(1), catchError((error: HttpErrorResponse) => {
                    if (error.status === 401) {
                        // auto logout if 401 response returned from api
                        this.authenticationService.logout();
                        location.reload(true);
                    }
                    let errorMessage = '';
                    let errorDescription = '';
                    if (error.error instanceof ErrorEvent) {
                        errorMessage = `Error: ${error.error.message}`;
                    } else {
                        errorMessage = 'Error:' + error.status;
                        errorDescription = error.message
                    }
                    console.log(errorMessage);
                    return throwError(errorMessage);
                })
            )
    }
}