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

	getUser(id: number): Observable<User> {
		return this.httpClient.get(USERS_URL+id).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<User>;	
	}

	addUser(user: User): Observable<User> {
		return this.httpClient.post<User>(USERS_URL, user).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<User>;
	}

	updateUser(user: User,id:number): Observable<User> {
		return this.httpClient.put<User>(USERS_URL+id, user).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}