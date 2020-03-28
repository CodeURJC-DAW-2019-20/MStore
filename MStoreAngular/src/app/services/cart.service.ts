import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';

const CART_URL = "https://localhost:8443/api/carts/";
@Injectable({ providedIn: 'root' })
export class CartService {

    constructor(private httpClient: HttpClient) { }

    getCart(): Observable<Post[]> {
		return this.httpClient.get(CART_URL).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Post[]>;	
    }

    removeCart() {
		return this.httpClient.delete(CART_URL).pipe(			
			catchError(error => this.handleError(error))
		);
	}
    
    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
}