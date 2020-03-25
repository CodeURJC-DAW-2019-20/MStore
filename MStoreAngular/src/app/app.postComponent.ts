import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  templateUrl: './app.postComponent.html',
  styleUrls: ['./app.componentpost.css'],
  providers: [NgbCarouselConfig]
})


export class postComponent {
  title = 'MStoreAngular';
  name = 'Post';
  features=['feature1', 'feature2', 'feature3'];
  details='details';
  price=0;
  category='category';
  id=0;
  subModule=[{active:false},{active:false},{active:false},{active:false}];
  recommendedPosts=[{id: 1, name: 'AMD card', price:55,  description: 'new AMD card'},
  {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
  {id: 3, name: 'AMD card 3', price:6,  description: 'new AMD card'}];
  images = [62, 83, 466, 965].map((n) => `https://picsum.photos/id/${n}/900/500`);


  constructor(activatedRoute:ActivatedRoute, config:NgbCarouselConfig) {
    this.id = activatedRoute.snapshot.params.id;
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
    config.interval=3000;
  }

  activateClass(subModule, i){
    subModule[i].active = true;    
  }
}
