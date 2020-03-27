import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from 'src/app/models/user.model';

const USERS_URL = "https://localhost:8443/api/users/";

@Injectable({ providedIn: 'root' })
export class UserService {

	constructor(private httpClient: HttpClient) { }

	getUsers(): Observable<User[]> {
		return this.httpClient.get(USERS_URL).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<User[]>;	
	}

	getUser(id:number): Observable<User> {
		return this.httpClient.get(USERS_URL+id).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<User>;	
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}