import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';
import { CartService } from './cart.service';

const POSTS_URL = "https://localhost:8443/api/posts/";

@Injectable({ providedIn: 'root' })
export class PostsService {

    constructor(private httpClient: HttpClient, cartService:CartService) { }

	getPosts(): Observable<Post[]> {
		return this.httpClient.get(POSTS_URL).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Post[]>;	
	}

	getPost(id: number): Observable<Post> {
		return this.httpClient.get(POSTS_URL+id).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Post>;	
	}

	removePost(post: Post) {
		return this.httpClient.delete(POSTS_URL + post.id).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	addPost(post: Post) {
		return this.httpClient.post(POSTS_URL, post).pipe(
			catchError(error => this.handleError(error))
		);
	}

	updatePost(post: Post) {
		return this.httpClient.put(POSTS_URL + post.id, post).pipe(
			catchError(error => this.handleError(error))
		);
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}