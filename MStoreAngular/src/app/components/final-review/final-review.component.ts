import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { PostsService } from 'src/app/services/posts.service';
import { Post } from 'src/app/models/post.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-final-review',
  templateUrl: './final-review.component.html',
  styleUrls: ['./final-review.component.css']
})
export class FinalReviewComponent implements OnInit {

  @Output()
  previous2 = new EventEmitter();

  cart: Post[] = [];

  user: User;
  id: number;
  index = 0;
  total = 0;
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  constructor(private router: Router, private cartService: CartService, private postService: PostsService, private userService: UserService, private loggedUserService: AuthenticationService) { }

  ngOnInit() {
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
  removePost(post:Post){
    this.postService.removePost(post).subscribe(
      postOut => {},
      error => console.error(error)
    )
  }

  removeCart() {
    let okResponse = window.confirm("Do you want to continue?");
    if (okResponse) {
      for (let i in this.cart) {
          this.removePost(this.cart[i]);
          
      }
      for (let i = 0; i < this.cart.length; i++) {
        this.cartService.removeFromCartIndex(i);
      }
      this.router.navigate(['/complete']);
    }
  }

  previous() {
    this.previous2.emit();
  }

}