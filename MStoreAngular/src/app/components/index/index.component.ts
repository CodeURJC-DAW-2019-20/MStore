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

  constructor(private router:Router,private postService:PostsService) {
  }
  ngOnInit(){
    this.postService.getPosts().subscribe(
      posts => this.posts = posts,
      error => console.log(error)
    );
    this.empty=this.posts.length==0;
    if (!this.empty) {
      this.carousel = this.posts.sort((e1, e2) => { if (e1.price > e2.price) { return -1 } else if (e1.price < e2.price) { return 1 } else { return 0; } }).slice(0,3);
      this.featuredPosts = this.posts.sort((e1, e2) => { if (e1.price > e2.price) { return 1 } else if (e1.price < e2.price) { return -1 } else { return 0; } }).slice(0,8);
      this.newArrivals = this.posts.sort((e1, e2) => { if (e1.id > e2.id) { return -1 } else if (e1.id < e2.id) { return 1 } else { return 0; } }).slice(0,8);
      this.topPost = this.carousel[0];
      }
  }
    

  }