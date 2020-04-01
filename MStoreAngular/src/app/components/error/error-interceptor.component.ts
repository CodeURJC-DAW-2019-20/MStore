import {HttpEvent,HttpHandler,HttpRequest,HttpErrorResponse,HttpInterceptor} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService, private router:Router) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(retry(1), catchError((error: HttpErrorResponse) => {
                    if (error.status === 404) {
                        this.router.navigate(['error-404']);
                    }
                    if (error.status === 500) {
                        this.router.navigate(['error-500']);
                    }
                    if (error.status === 403) {
                        this.router.navigate(['error-403']);
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