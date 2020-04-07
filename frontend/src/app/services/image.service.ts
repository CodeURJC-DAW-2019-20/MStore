import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from 'src/app/models/user.model';
import { Image } from 'src/app/models/image.model';

const USERS_URL = "https://localhost:8443/api/users/";
const POSTS_URL = "https://localhost:8443/api/posts/";

@Injectable({ providedIn: 'root' })
export class ImageService {

	constructor(private httpClient: HttpClient) { }

	getUserImage(id:number): Observable<Image> {
		return this.httpClient.get(USERS_URL+id+'/images').pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Image>;	
	}

	addUserImage(id:number,data:FormData): Observable<FormData> {
		const options:HttpHeaders = new HttpHeaders();
		options.append("Content-Type","application/x-www-form-urlencoded");
		return this.httpClient.post<FormData>(USERS_URL+id+'/images', data, {headers:options}).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	updateUserImage(id:number,data:FormData): Observable<FormData> {
		const options:HttpHeaders = new HttpHeaders();
		options.append("Content-Type","application/x-www-form-urlencoded");
		return this.httpClient.put<FormData>(USERS_URL+id+'/images', data,{headers:options}).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	getPostImages(id:number): Observable<Image[]> {
		return this.httpClient.get(POSTS_URL+id+'/images').pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Image[]>;	
	}

	addPostImage(id:number,data:FormData): Observable<FormData> {
		const options:HttpHeaders = new HttpHeaders();
		options.append("Content-Type","application/x-www-form-urlencoded");
		return this.httpClient.post<FormData>(POSTS_URL+id+'/images', data, {headers:options}).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	updatePostImage(id:number,idImg:number,data:FormData): Observable<FormData> {
		const options:HttpHeaders = new HttpHeaders();
		options.append("Content-Type","application/x-www-form-urlencoded");
		return this.httpClient.put<FormData>(POSTS_URL+id+'-'+idImg+'/images', data,{headers:options}).pipe(			
			catchError(error => this.handleError(error))
		);
	}
	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}