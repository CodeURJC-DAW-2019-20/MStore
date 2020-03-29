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
  cart : Post[];
  length: number;
  src:string = "https://finofilipino.org/wp-content/uploads/2019/11/wesrgfwerthertyhj.jpg"

  constructor(private cartService: CartService, private authenticationService: AuthenticationService) {
    this.cart = this.cartService.getCart();
    this.total =this.cartService.getTotal();
  }

  logOut() {
    this.authenticationService.logout();
  }

  initCart() {
    this.cartService.postCart().subscribe(
      error => console.log(error)
    );
  }

}