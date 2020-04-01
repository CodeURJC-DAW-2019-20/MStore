import { Component, NgZone,OnInit,Input } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Post} from 'src/app/models/post.model';
import { User } from 'src/app/models/user.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: User;
  isLogged:boolean;
  isAdmin:boolean;
  total = 0;
  cart : Post[]=[]
  length: number;
  src:string = "./assets/img/sanchis.png"
  testVariable: string;

  constructor(private cartService: CartService, private authenticationService: AuthenticationService, private _ngZone: NgZone) {
  }

  ngOnInit(){
    this.isLogged=this.authenticationService.isUserLog();
    if(this.isLogged){
      this.user=this.authenticationService.currentUserValue;
      this.isAdmin=this.user.roles.includes("ROLE_ADMIN");
    }
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
    location.reload();
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