import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';

interface Post {
  id: number;
  name: string;
  component: string;
  brand: Brand;
  price: number;
  tags?: Array<String>;
  details: string;
  features?: string;
}

interface Brand {
  name: string;
}

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  posts: Array<string>;
  brand: Brand;
  post: Post;

  searching: boolean;
  found: boolean;
  edit: boolean;
  remove: boolean;

  constructor() {
  }

  ngOnInit(): void {
    this.searching = false;
    this.found = true;
    this.edit = false;
    this.remove = false;

    this.posts = ['Manolo', 'Ramón', 'PEPE', 'pepito', 'pepon'];
    this.brand = { name: 'toshiba' };
    this.post = { id: 4, name: 'Monitor 4', component: 'CPU', brand: this.brand, price: 66,
     tags: ['barato','nuevo'],details: 'new Monitor' };
  }

  public showSearchResults(event: any): void {
    if (event.target.value.length >= 1) {
      this.searching = true;
    } else {
      this.searching = false;
    }
  }

  public onRemove(id: number) {
    
  }

  public onEdit(id: number) {
    this.edit = true;
  }

}
