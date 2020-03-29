import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Post } from 'src/app/models/post.model';
import { $ } from 'protractor';

const CART_URL = "https://localhost:8443/api/carts/";

@Injectable({ providedIn: 'root' })
export class CartService {
	cart:Post[]=[];

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
		let cart=JSON.parse(sessionStorage.getItem("cart"));
		if (cart==null){
			let cartaux:Post[]=[];
			sessionStorage.setItem("cart", JSON.stringify(cartaux));
			cart=cartaux;
		}
		return cart;
	}

	getCartO(): Observable<Post[]>{
		let cart=JSON.parse(sessionStorage.getItem("cart"));
		if (cart==null){
			let cartaux:Post[]=[];
			sessionStorage.setItem("cart", JSON.stringify(cartaux));
			cart=cartaux;
		}
		return of(cart);
	}


	getTotal(){
		let total=JSON.parse(sessionStorage.getItem("total"));
		if (total==null){
			let totalaux=0;
			sessionStorage.setItem("total",JSON.stringify(totalaux));
			return total;
		}
		return total;
	}

	addToCart(post:Post){
		let cart:Post[]=JSON.parse(sessionStorage.getItem("cart"));
		let total=JSON.parse(sessionStorage.getItem("total"));
		let totalaux=total+post.price;
		cart.push(post);
		sessionStorage.setItem("total",JSON.stringify(totalaux));
		sessionStorage.setItem("cart", JSON.stringify(cart));
	}

	contains(id:number){
		let cart:Post[]=JSON.parse(sessionStorage.getItem("cart"));
		for (let index = 0; index < cart.length; index++) {
			let postaux:Post;
			postaux=cart[index];
			if (postaux.id==id) {
				return true;
			}
		}
		return false;
	}
	
	removeFromCartIndex(i:number){
		let cart:Post[]=JSON.parse(sessionStorage.getItem("cart"));
		let total=JSON.parse(sessionStorage.getItem("total"));
		let post:Post = cart[i];
		let totalaux=total-post.price;
		cart.splice(i,1);
		sessionStorage.setItem("total",JSON.stringify(totalaux));
		sessionStorage.setItem("cart", JSON.stringify(cart));
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