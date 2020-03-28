import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {CartService} from 'src/app/services/cart.service';
import {PostsService} from 'src/app/services/posts.service';
import {Post} from 'src/app/models/post.model';
import {User} from 'src/app/models/user.model';

@Component({
  selector: 'app-final-review',
  templateUrl: './final-review.component.html',
  styleUrls: ['./final-review.component.css']
})
export class FinalReviewComponent implements OnInit {

  @Output()
  previous2 = new EventEmitter();

  cart: Post[]=[];

  user={firstName:"Marcos",lastName:"Ruiz Muñoz",email:"mr@gmail.com",userAddress:"Miami Street",password:"mr",phone:"55478544",creditCard:"5645544"}
  total=0;
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  constructor(private router:Router,private cartService:CartService,private postService:PostsService) { }

  ngOnInit() {
    this.cartService.getCart().subscribe(
      cart=>{
        this.cart=cart;
        for (let i in this.cart){
          this.total+=this.cart[i].price;
        }
      },
      error =>error => console.log(error)
    );
  }

  removeCart() {
    let okResponse = window.confirm("Do you want to continue?");
    if (okResponse) {
        this.cartService.removeCart().subscribe(
            book => {
              for(let i in this.cart){
                this.postService.removePost(this.cart[i]).subscribe(
                  book => {},
                  error => console.error(error)
              )

              }
              this.router.navigate(['/complete'])
          },
            error => console.error(error)
        )
    }
}

  previous() {
    this.previous2.emit();
  }
  
}
