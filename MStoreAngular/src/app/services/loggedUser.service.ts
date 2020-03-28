import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from 'src/app/models/user.model';
import { LoggedUser } from 'src/app/models/loggedUser.model';
const LOGIN_URL = "https://localhost:8443/api/logIn/";
const LOGOUT_URL = "https://localhost:8443/api/logOut/";

@Injectable({ providedIn: 'root' })
export class LoggedUserService {
	headers:HttpHeaders;
	loggedUser:LoggedUser;
	constructor(private httpClient: HttpClient) { }

	ngOnInit(){
		this.loggedUser={email:"",password:"",isLoggued:false}
	}

	setLoggedUserInfo(user:LoggedUser){
		this.loggedUser=user;
	}

	isUserLog(){
		return this.loggedUser.isLoggued;
	}

	getLogguedUserInfo(){
		return this.loggedUser;
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}