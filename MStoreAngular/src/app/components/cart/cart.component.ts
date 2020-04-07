import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Post } from 'src/app/models/post.model';


@Component({
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items:Post[]=[];
  id=0;
  total=0;
  src:string;
  
  @Output() 
  onRemove: EventEmitter<Post[]> = new EventEmitter<Post[]>();

  constructor(private cartService:CartService) {
  }

  ngOnInit(){
    this.items=this.cartService.getCart();
    this.total=this.cartService.getTotal();
  }

  removeItem(i:number){
    this.cartService.removeFromCartIndex(i);
    this.onRemove.emit(this.items);
    window.location.reload();
  }
}
