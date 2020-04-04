import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { PostsService } from 'src/app/services/posts.service';
import { Post } from 'src/app/models/post.model';
import { User } from 'src/app/models/user.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-final-review',
  templateUrl: './final-review.component.html',
  styleUrls: ['./final-review.component.css']
})
export class FinalReviewComponent implements OnInit {

  @Output()
  previous2 = new EventEmitter();

  @Input()
  user: User;

  cart: Post[] = [];

  index = 0;
  total = 0;
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  constructor(private router: Router, private cartService: CartService, private postService: PostsService, private userService: UserService) { }

  ngOnInit() {
    this.getCart();
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

  removePost(post: Post) {
    this.postService.removePost(post.id).subscribe(
      _ => { },
      error => console.error(error)
    )
  }

  buy() {
    let okResponse = window.confirm("Do you want to continue?");
    if (okResponse) {
      for (let i in this.cart) {
        this.removePost(this.cart[i]);

      }
      this.cartService.resetCart();
      this.router.navigate(['/complete']).then(() => {
        window.location.reload();
      });
    }
  }

  previous() {
    this.previous2.emit();
  }

}