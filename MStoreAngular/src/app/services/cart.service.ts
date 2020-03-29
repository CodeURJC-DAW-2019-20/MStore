import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';

const CART_URL = "https://localhost:8443/api/carts/";

@Injectable({ providedIn: 'root' })
export class CartService {
	cart:Post[];

	constructor(private httpClient: HttpClient) { }
	
	headers = {
		'Content-Type': 'application/json',
		'Accept': 'application/json',
		'Access-Control-Allow-Headers': 'Content-Type',
	  }
	  
	  requestOptions = {                                                                                                                                                                                 
		headers: new HttpHeaders(this.headers), 
	  };
	  

    getCart(){
		if (this.cart==null){
			this.cart=[];
		}
		return this.cart;
	}

	getTotal(){
		let total=0;
		for (let index = 0; index < this.cart.length; index++) {
			total=total+this.cart[index].price;
		}
		return total;
	}

	addToCart(post:Post){
		if (this.cart==null){
			this.cart=[];
		}
		this.cart.push(post);
	}

	contains(post:Post){
		return this.cart.indexOf(post) > -1
	}

	removeFromCart(post:Post){
		this.cart.splice(this.cart.indexOf(post),1);
	}

	removeFromCartIndex(i:number){
		this.cart.splice(i,1);
	}
	
	postCart() {
		return this.httpClient.post(CART_URL, null).pipe(			
			catchError(error => this.handleError(error))
		);
	}

	putCart(id:number) {
		return this.httpClient.put(CART_URL+id, null).pipe(			
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