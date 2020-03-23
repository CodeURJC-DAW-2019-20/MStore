import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { typeWithParameters } from '@angular/compiler/src/render3/util';

@Component({
  templateUrl: './app.postComponent.html',
  styleUrls: []
})
export class postComponent {
  title = 'MStoreAngular';
  name = 'Post';
  features='feature1';
  details='details';
  price='price';
  category='category';
  id=0;

  constructor(activatedRoute:ActivatedRoute) {
    this.id = activatedRoute.snapshot.params.id;
  }

}
