import { Component, OnInit } from '@angular/core';
import { PostsService } from 'src/app/services/posts.service';
import { Post } from 'src/app/models/post.model';
import { CommunicationService } from 'src/app/services/communication.service';

@Component({
  templateUrl: './index.component.html',
  styleUrls: []
})
export class IndexComponent implements OnInit {
  images = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9].map((n) => `assets/img/brands/${n}.jpg`);
  title1 = 'Featured Products';
  title2 = 'New Arrivals';
  empty: boolean;
  posts: Post[] = [];
  carousel: Post[];
  featuredPosts: Post[];
  newArrivals: Post[];
  topPost: Post;
  pauseOnHover = true;
  l: number;
  path = "https://i.ibb.co/F0021cN/hero-main-bg.jpg";

  constructor(
    private postService: PostsService,
    private communicationService: CommunicationService) {
  }
  ngOnInit() {

    this.postService.getPosts().subscribe(
      posts => {
        this.posts = posts;
        this.empty = this.posts.length == 0;
        if (!this.empty) {
          this.loadCarousel();
          this.loadFeaturedPosts();
          this.loadNewArrivals();
        }
      },
      error => {
        this.empty = true;
        console.log(error)
      }
    );
  }

  loadCarousel() {
    this.postService.getPostsByPriceDESC().subscribe(
      response => {
        this.carousel = response;
        this.carousel = this.carousel.slice(0, 3);
        this.topPost = this.carousel[0];
      },
      error => {
        console.log(error)
      }
    )
  }

  loadNewArrivals() {
    this.newArrivals = this.posts.sort((e1, e2) => { if (e1.id > e2.id) { return -1 } else if (e1.id < e2.id) { return 1 } else { return 0; } }).slice(0, 9);
  }

  loadFeaturedPosts() {
    this.postService.getPostsByPriceASC().subscribe(
      response => {
        this.featuredPosts = response;
        this.featuredPosts = this.featuredPosts.slice(0, 9);
      },
      error => {
        console.log(error)
      }
    )
  }

  changePosts(idPost: number, searchPost: string) {
    this.communicationService.emitChange({id: idPost, search: searchPost});
  }

}