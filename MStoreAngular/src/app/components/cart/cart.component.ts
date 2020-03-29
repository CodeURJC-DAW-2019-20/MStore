import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CartService } from 'src/app/services/cart.service';
import { Post } from 'src/app/models/post.model';


@Component({
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  items:Array<Post>=[];
  id=0;
  total=320;
  src:string = "https://finofilipino.org/wp-content/uploads/2019/11/wesrgfwerthertyhj.jpg"

  constructor(private cartService:CartService) {
    this.items=this.cartService.getCart();
  }

  removeItem(i:number){
    this.cartService.removeFromCartIndex(i);

  }

}
