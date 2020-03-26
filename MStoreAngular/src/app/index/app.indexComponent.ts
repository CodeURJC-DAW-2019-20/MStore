import { Component,ViewChild} from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';

interface Post{
    id:number;
    name:string;
    price:number;
    description:string;
}
@Component({
  templateUrl: './app.indexComponent.html',
  styleUrls: []
})
export class indexComponent {
    images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
    title1 = 'Featured Products';
    title2 = 'New Arrivals';
    carousel:Array<Post>;
    featuredPosts:Array<Post>;
    newArrivals:Array<Post>;
    topPost:Post;
    pauseOnHover = true;
  
  constructor() {
      this.carousel=[{id: 1, name: 'AMD card', price:55,  description: 'new AMD card'},
      {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
      {id: 3, name: 'AMD card 3', price:6,  description: 'new AMD card'}];

      this.featuredPosts=[
      {id: 4, name: 'Monitor 4', price:66,  description: 'new Monitor'},
      {id: 5, name: 'Monitor 5', price:785,  description: 'new Monitor'},
      {id: 6, name: 'Monitor 6', price:7,  description: 'new Monitor'},
      {id: 7, name: 'Monitor 7', price:8,  description: 'new Monitor'},
      {id: 8, name: 'Monitor 8', price:55,  description: 'new Monitor'},
      {id: 9, name: 'Monitor 9', price:53,  description: 'new Monitor'},
      {id: 10, name: 'Monitor 10', price:55,  description: 'new Monitor'},
      {id: 11, name: 'Monitor 11', price:147,  description: 'new Monitor'}
    ];

      this.newArrivals=[
      {id: 11, name: 'Scanner 11', price:52, description:'new Scanner'},
      {id: 12, name: 'Scanner 12', price:15,  description: 'new Scanner'},
      {id: 13, name: 'Scanner 13', price:585,  description: 'new Scanner'},
      {id: 14, name: 'Scanner 14', price:85,  description: 'new Scanner'},
      {id: 15, name: 'Scanner 15', price:78,  description: 'new Scanner'},
      {id: 16, name: 'Scanner 16', price:7,  description: 'new Scanner'},
      {id: 17, name: 'Scanner 17', price:26,  description: 'new Scanner'},
      {id: 18, name: 'Scanner 18', price:978,  description: 'new Scanner'}];

      this.topPost={id:20,name:'HP Printer', price:5582, description:'The best HP Printer'}
  }

}