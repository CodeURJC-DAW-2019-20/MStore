import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { PostsService } from 'src/app/services/posts.service';
import { getHeapCodeStatistics } from 'v8';
import { Post } from 'src/app/models/post.model';

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
  images = [62, 83, 466, 965].map((n) => `https://picsum.photos/id/${n}/900/500`);

  constructor(activatedRoute:ActivatedRoute, config:NgbCarouselConfig, private postService:PostsService) { 
    this.id = activatedRoute.snapshot.params.id;
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
    config.interval=3000;
    this.getPost(this.id);
  }

  getPost(id:number){
    this.postService.getPost(id).subscribe(
      post => {
        this.post=post;
      },
      error => console.log(error)
    );
  }

  activateClass(subModule, i) {
    subModule[i].active = true;
  }

  ngOnInit(): void {
  }

}
