import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

interface post {
  id:number;
  name:string;
  description:string;
  }

@Component({
  templateUrl: './app.cartComponent.html',
  styleUrls: ['./app.componentcart.css']
})
export class cartComponent {
  items:Array<post>;
  empty=true;
  id=0;
  total=0;

  constructor() {
  }

}
