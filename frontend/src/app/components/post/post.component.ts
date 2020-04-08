import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { PostsService } from 'src/app/services/posts.service';
import { Post } from 'src/app/models/post.model';
import { CartService } from 'src/app/services/cart.service';
import { GraphicsService } from 'src/app/services/graphics.service';
import { User } from 'src/app/models/user.model';
import { AuthenticationService } from 'src/app/services/authentication.service';

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
  recommendedPosts: Post[]=[];
  empty:boolean;
  rates: number[]=[];
  userID: number;
  seller:User;
  medianrate=4;
  totalrates=0;
  sameuser:boolean;
  Contained=true;
  imgsUrl: string[];
  currentUser: number;
  
  ngOnInit(){
    this.imgsUrl = [];
    this.getPost(this.id);
    this.Contained=this.cartService.contains(this.id);
    this.getTopPosts();    
  }
  
  constructor(activatedRoute:ActivatedRoute, config:NgbCarouselConfig, private postService:PostsService, private cartService:CartService, private graphicsService:GraphicsService, private authenticationService:AuthenticationService) {
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
    config.interval=3000; 
    this.getLoggedUser();
    this.id = activatedRoute.snapshot.params.id;

  }
  
  getLoggedUser(){
    this.authenticationService.currentUser.subscribe(
      user => {
        this.currentUser= user.id;
        },
      error => console.log(error)
    );
  }

  
  getPost(id:number){
    this.postService.getPost(id.toString()).subscribe(
      post => {
        this.post=post;
        this.seller=post.user;
        this.userID=post.user.id;
        this.getRatings(this.userID);
        for (let i = 0; i < this.post.nImg; i++) {
          this.imgsUrl[i] = 'https://localhost:8443/images/posts/image-' + id + '-' + i + '.jpg';
        }
      },
      error => console.log(error)
    );
  }

  getTopPosts(){
    this.postService.getTopPosts().subscribe(
      topPosts => {
        this.recommendedPosts = topPosts
        this.empty=this.recommendedPosts.length==0;},
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

  getError(id:number){
    this.cartService.putCart(id).subscribe(
      graph => {
        this.convertRatings();
      },
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
    this.Contained=true;
    window.location.reload();
  }
}
