import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

interface post {
  id:number;
  name:string;
  price: number;
  description:string;
  }

@Component({
  templateUrl: './app.cartComponent.html',
  styleUrls: ['./app.componentcart.css']
})
export class cartComponent {
  items:Array<post>;
  id=0;
  total=320;
  src:string = "https://finofilipino.org/wp-content/uploads/2019/11/wesrgfwerthertyhj.jpg"

  constructor() {
    this.items =[{id: 1, name: 'AMD card', price:55,  description: 'new AMD card'},
      {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
      {id: 3, name: 'AMD card 3', price:6,  description: 'new AMD card'}];
  }

}
