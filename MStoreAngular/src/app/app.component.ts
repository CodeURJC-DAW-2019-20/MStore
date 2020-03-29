import { Component, NgZone } from '@angular/core';
import { CartService } from './services/cart.service';
import { Post } from './models/post.model';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MStoreAngular';
  total = 0;
  cart : Post[]=[]
  length: number;
  src:string = "./assets/img/sanchis.png"
  testVariable: string;

  constructor(private cartService: CartService, private authenticationService: AuthenticationService, private _ngZone: NgZone) {
  }

  ngOnInit(){
    this.cartService.getCartO().subscribe(
      cart => {
          this.cart=cart;
        },
      error => console.log(error),
    );
    this.total= this.cartService.getTotal();
  }

  logOut() {
    this.authenticationService.logout();
  }

  Update(cart:Post[]){
    this.cart = this.cartService.getCart();
    this.total =this.cartService.getTotal();
  }

  UpdateAdd(post:Post){
    this.cart = this.cartService.getCart();
    this.total =this.cartService.getTotal();
  }

}