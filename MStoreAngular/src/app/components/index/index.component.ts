import { Component, ViewChild, OnInit } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { PostsService } from 'src/app/services/posts.service';
import {Post} from 'src/app/models/post.model';
@Component({
  templateUrl: './index.component.html',
  styleUrls: []
})
export class IndexComponent implements OnInit {
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  title1 = 'Featured Products';
  title2 = 'New Arrivals';
  empty: boolean;
  posts: Post[]=[];
  carousel: Post[];
  featuredPosts: Post[];
  newArrivals: Post[];
  topPost: Post;
  pauseOnHover = true;
  l:number;
  path="https://i.ibb.co/F0021cN/hero-main-bg.jpg";

  constructor(private router:Router,private postService:PostsService) {
  }
  ngOnInit(){

    this.postService.getPosts().subscribe(
      posts => {
        this.posts = posts;
        this.empty=this.posts.length==0;
        if (!this.empty) {
          this.loadCarousel();
          this.loadFeaturedPosts();
          this.loadNewArrivals();
        }
      },
      error => {
        this.empty=true;
        console.log(error)
        }
    );
  }

  loadCarousel(){
    this.postService.getPostsByPriceDESC().subscribe(
      response => {
        this.carousel = response;
        this.carousel= this.carousel.slice(0,3);
        this.topPost=this.carousel[0];
      },
      error =>{
        console.log(error)
        }
    )
  }

  loadNewArrivals(){
    this.newArrivals = this.posts.sort((e1, e2) => { if (e1.id > e2.id) { return -1 } else if (e1.id < e2.id) { return 1 } else { return 0; } }).slice(0,8);
  }

  loadFeaturedPosts(){
    this.postService.getPostsByPriceASC().subscribe(
      response => {
        this.featuredPosts = response;
        this.featuredPosts = this.featuredPosts.slice(0,8);
      },
      error =>{
        console.log(error)
        }
    )
  }
    

  }