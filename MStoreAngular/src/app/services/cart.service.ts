import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';

const CART_URL = "https://localhost:8443/api/carts/";

@Injectable({ providedIn: 'root' })
export class CartService {

	constructor(private httpClient: HttpClient) { }
	
	
	headers = {
		'Content-Type': 'application/json',
		'Accept': 'application/json',
		'Access-Control-Allow-Headers': 'Content-Type',
	  }
	  
	  requestOptions = {                                                                                                                                                                                 
		headers: new Headers(this.headers), 
	  };
	  

    getCart(){
		return this.httpClient.get(CART_URL).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Post[]>;	
	}
	
	postCart() {
		return this.httpClient.post(CART_URL, this.requestOptions).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	putCart(id:number) {
		return this.httpClient.put(CART_URL+id, this.requestOptions).pipe(			
			catchError(error => this.handleError(error))
		);
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