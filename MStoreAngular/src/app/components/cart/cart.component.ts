import { Component, EventEmitter, Output } from '@angular/core';
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
  items:Post[]=[];
  id=0;
  total=0;
  src:string = "./assets/img/sanchis.png"
  @Output() 
  onRemove: EventEmitter<Post[]> = new EventEmitter<Post[]>();

  constructor(private cartService:CartService) {
    this.items=this.cartService.getCart();
    this.total=this.cartService.getTotal();
  }

  removeItem(i:number){
    this.cartService.removeFromCartIndex(i);
    this.onRemove.emit(this.items);
    window.location.reload();
  }
}
