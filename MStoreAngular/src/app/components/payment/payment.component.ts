import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Post } from 'src/app/models/post.model';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  @Output()
  next1 = new EventEmitter();

  cart: Post[] = [];

  user: User;
  id: number;
  total: number;

  constructor(
    private cartService: CartService, 
    private userService: UserService,
    private loggedUserService: AuthenticationService
    ) { }

  ngOnInit(): void {
    this.total = 0;
    this.getCart();
    this.id = this.loggedUserService.currentUserValue.id;
    this.getUser(this.id);
  }

  getCart() {
    this.cartService.getCartO().subscribe(
      cart => {
        this.cart = cart;
      },
      error => console.log(error),
    );
    this.total = this.cartService.getTotal();
  }

  getUser(id: number) {
    this.userService.getUser(id).subscribe(
      user => {
        this.user = user;
      },
      error => console.log(error)
    );
  }

  onSubmit() {
    let password = this.user.password;
    this.user.password = '';
    this.userService.updateUser(this.user,this.id).subscribe(
      user => this.user = user,
      error => console.log(error)
    );
    this.user.password = password;
    this.user.creditCard = +this.user.creditCard.toString().substr(this.user.creditCard.toString().length - 4);
    this.next1.emit(this.user);
  }

}
