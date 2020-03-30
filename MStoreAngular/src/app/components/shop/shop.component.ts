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
  selected ="hola"
  currentBrand;
  showHardware = false;
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

  searchByPriceASC() {
    this.postService.getPostsByPriceASC().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );
  }

  searchByPriceDESC() {
    this.postService.getPostsByPriceDESC().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );
  }

  searchByNameASC() {
    this.postService.getPostsByNameASC().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );
  }

  searchByNameDESC() {
    this.postService.getPostsByNameDESC().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );
  }

  setBrand(id:number) {
    this.brandService.getBrand(id).subscribe(
      response => {
        this.currentBrand = response
        this.posts = this.currentBrand.posts
      },
      error => console.log(error)
    );
  }

  constructor(private router:Router,private postService:PostsService, private brandService:BrandService) { }

  ngOnInit(): void {
    this.postService.getPosts().subscribe(
      response => {
        this.posts = response;
        this.empty=this.posts.length==0;
        this.page = 0;
      },
      error => console.log(error)
    );

    this.brandService.getBrands().subscribe(
      response => {
        this.brands = response;
      },
      error => console.log(error)
    );

  }

}
