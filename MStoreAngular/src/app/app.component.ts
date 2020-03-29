import { Component } from '@angular/core';
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
  Cartonline = false;
  cart: Post[];

  constructor(private cartService: CartService, private authenticationService: AuthenticationService) {
    if (this.Cartonline == false) {
      this.initCart();
      this.Cartonline = true;
    }
    this.getCart();
  }

  logOut() {
    this.authenticationService.logout();
  }

  initCart() {
    this.cartService.postCart().subscribe(
      error => console.log(error)
    );
  }

  getCart() {
    this.cartService.getCart().subscribe(
      cart => {
        this.cart = cart;
      },
      error => console.log(error)
    );
  }

}