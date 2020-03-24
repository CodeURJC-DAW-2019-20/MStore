import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';

@Component({
  templateUrl: './app.postComponent.html',
  styleUrls: ['./app.componentpost.css']
})
export class postComponent {
  title = 'MStoreAngular';
  name = 'Post';
  features=['feature1', 'feature2', 'feature3'];
  details='details';
  price=0;
  category='category';
  id=0;

  constructor(activatedRoute:ActivatedRoute) {
    this.id = activatedRoute.snapshot.params.id;
  }

}
