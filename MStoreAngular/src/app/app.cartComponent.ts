import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';

interface post {
  id:number;
  name:string;
  description:string;
  }

@Component({
  templateUrl: './app.cartComponent.html',
  styleUrls: []
})
export class cartComponent {
  items:Array<post>;
  id=0;

  constructor() {
   
  }

}
