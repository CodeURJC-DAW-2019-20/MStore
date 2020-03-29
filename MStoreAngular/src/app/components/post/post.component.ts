import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { PostsService } from 'src/app/services/posts.service';
import { getHeapCodeStatistics } from 'v8';
import { Post } from 'src/app/models/post.model';
import { CartService } from 'src/app/services/cart.service';
import { GraphicsService } from 'src/app/services/graphics.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
  providers: [NgbCarouselConfig]
})
export class PostComponent implements OnInit {

  title = 'MStoreAngular';
  id=0;
  subModule=[{active:false},{active:false},{active:false},{active:false}];
  title2 = 'Related Products'
  post:Post;
  recommendedPosts=[{id: 1, name: 'AMD card', price:55,  description: 'new AMD card'},
  {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
  {id: 3, name: 'AMD card 3', price:6,  description: 'new AMD card'}];
  rates: number[]=[];
  userID: number;
  medianrate=4;
  totalrates=0;
  Contained=true;
  images = [62, 83, 466, 965].map((n) => `https://picsum.photos/id/${n}/900/500`);

  ngOnInit(){
    this.getPost(this.id);
  }
  
  constructor(activatedRoute:ActivatedRoute, config:NgbCarouselConfig, private postService:PostsService, private cartService:CartService, private graphicsService:GraphicsService) {
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
    config.interval=3000; 
    this.id = activatedRoute.snapshot.params.id;
  }

  getPost(id:number){
    this.postService.getPost(id).subscribe(
      post => {
        this.post=post;
        this.userID=post.user.id;
        this.getRatings(this.userID);
      },
      error => console.log(error)
    );
  }

  getRatings(id:number){
    this.graphicsService.getGraphic(id).subscribe(
      graph => {
        this.rates=graph;
        this.convertRatings();
      },
      error => console.log(error)
    );
  }

  convertRatings(){
    let total=0;
    for (let index = 0; index < this.rates.length; index++) {
        total=total+this.rates[index]*index;
        this.totalrates= this.totalrates+this.rates[index];
    }
   this.medianrate=total/this.totalrates;
  }

  activateClass(subModule, i) {
    subModule[i].active = true;
  }

  addToCart () {
    this.cartService.addToCart(this.post);
  }
}
