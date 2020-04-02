import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.model';
import { Router } from '@angular/router';
import { PostsService } from 'src/app/services/posts.service';
import { HttpClient } from '@angular/common/http';
import { BrandService } from 'src/app/services/brand.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  currentBrand;
  currentTag;
  currentOrd;
  currentSortBy;
  showHardware = false;
  showMore;
  showFilter;
  showAcc = true;
  showPrint = true;
  posts = []
  brands = []
  page;
  empty = false

  toggleNavbarHW() {
    this.showHardware = !this.showHardware;
  }

  toggleNavbarAC() {
    this.showAcc = !this.showAcc;
  }

  toggleNavbarPrint() {
    this.showPrint = !this.showPrint;
  }

  getAllPosts(){
    this.postService.getPosts().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );
  }


  changeCriteriaPost(tag: string, sortBy:string, ord:string) {
    this.postService.getPostByCriteria(ord, sortBy, 0, tag).subscribe(
      response => {
        this.showFilter = true;
        this.posts = response;
        this.empty = this.posts.length == 0;
        this.showMore = this.posts.length == 10;
        this.page = 0;
        this.currentTag = tag;
        this.currentOrd = ord;
        this.currentSortBy = sortBy;
      },
      error => console.log(error)
    );

  }

  morePosts() {
    this.page = this.page + 1;
    this.postService.getPostByCriteria(this.currentOrd, this.currentSortBy, this.page, this.currentTag)
    .subscribe(
      response => {
        this.posts = this.posts.concat(response);
        this.showMore = response.length == 10;
      },
      error => console.log
    );

  }

  setBrand(id:number) {
    this.brandService.getBrand(id).subscribe(
      response => {
        this.currentBrand = response
        this.posts = this.currentBrand.posts
        this.showMore = false;
        this.showFilter = false;
      },
      error => console.log(error)
    );
  }

  constructor(private router:Router,private postService:PostsService, private brandService:BrandService) { }

  ngOnInit(): void {
    this.currentTag = -1;
    this.showFilter = true;
    this.showMore = true;
    this.currentOrd = 'asc';
    this.currentSortBy = 'id';
    this.brandService.getBrands().subscribe(
      response => {
        this.brands = response;
      },
      error => console.log(error)
    );

  }

}
