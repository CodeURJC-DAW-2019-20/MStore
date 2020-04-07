import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';
import { CartService } from './cart.service';

const POSTS_URL = "https://localhost:8443/api/posts/";

@Injectable({ providedIn: 'root' })
export class PostsService {

	constructor(private httpClient: HttpClient, cartService: CartService) { }

	getPosts(): Observable<Post[]> {
		return this.httpClient.get(POSTS_URL).pipe(
			catchError(error => this.handleError(error))
		) as Observable<Post[]>;
	}

	getPostsByName(name: string): Observable<Post[]> {
		return this.httpClient.get(POSTS_URL + "?name=" + name)
		.pipe(catchError(error => this.handleError(error))) as Observable<Post[]>
  }

  getPostByCriteria(ord, sortBy, pageNumber, tag): Observable<Post[]> {
    return this.httpClient.get(POSTS_URL + "?sortBy=" + sortBy + "&ord=" + ord + "&pageNo=" + pageNumber + "&tag=" + tag)
    .pipe(catchError(error => this.handleError(error))) as Observable<Post[]>;
  }

	getPostsByPriceASC(): Observable<Post[]> {
		return this.httpClient
			.get(POSTS_URL + "?sortBy=price&ord=asc&pageNo=0")
			.pipe(catchError(error => this.handleError(error))) as Observable<Post[]>;
	}

	getPostsByPriceDESC(): Observable<Post[]> {
		return this.httpClient
			.get(POSTS_URL + "?sortBy=price&ord=desc&pageNo=0")
			.pipe(catchError(error => this.handleError(error))) as Observable<Post[]>;
	}

	getPostsByNameASC(): Observable<Post[]> {
		return this.httpClient
			.get(POSTS_URL + "?sortBy=name&ord=asc&pageNo=0")
			.pipe(catchError(error => this.handleError(error))) as Observable<Post[]>;
	}

	getPostsByNameDESC(): Observable<Post[]> {
		return this.httpClient
			.get(POSTS_URL + "?sortBy=name&ord=desc&pageNo=0")
			.pipe(catchError(error => this.handleError(error))) as Observable<Post[]>;
	}


	getTopPosts(): Observable<Post[]> {
		return this.httpClient.get(POSTS_URL + "top-posts").pipe(
			catchError(error => this.handleError(error))
		) as Observable<Post[]>;
	}

	getPost(id: string): Observable<Post> {
		return this.httpClient.get(POSTS_URL + id).pipe(
			catchError(error => this.handleError(error))
		) as Observable<Post>;
	}

	removePost(id: number) {
		return this.httpClient.delete(POSTS_URL + id).pipe(
			catchError(error => this.handleError(error))
		);
	}

	addPost(post: Post): Observable<Post> {
		return this.httpClient.post(POSTS_URL, post).pipe(
			catchError(error => this.handleError(error))
		) as Observable<Post>;
	}

	updatePost(post: Post) {
		return this.httpClient.put(POSTS_URL + post.id, post).pipe(
			catchError(error => this.handleError(error))
		) as Observable<Post>;
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}
