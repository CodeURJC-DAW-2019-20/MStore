import { Component } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GraphicsService } from 'src/app/services/graphics.service';
import { User } from 'src/app/models/user.model';
import { Post } from 'src/app/models/post.model';

@Component({
  templateUrl: './profile.component.html',
  styleUrls: []
})
export class MyProfileComponent {

  user:User;
  id:number;
  src:string;
  chart:CanvasJS.Chart;
  chartData:number[] = [];
  canRate:boolean;
  stars:number;
  title:string;
  userPosts:Array<Post>;
  empty:boolean;

  constructor(private userService:UserService, private graphicsService:GraphicsService, private loggedUserService: AuthenticationService) {
  }

  ngOnInit() {
    this.canRate=false;
    this.id=this.loggedUserService.currentUserValue.id;
    this.title="Sellers products";
    this.getUser(this.id);
    this.getGraph(this.id);   
  }

  createGraph(data:number[]){
    this.chart = new CanvasJS.Chart("chartContainer", {
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: "Seller rating"
      },
      data: [{
        type: "column",
        dataPoints: [
          { y: data[5], label: "5 stars" },
          { y: data[4], label: "4 stars" },
          { y: data[3], label: "3 stars" },
          { y: data[2], label: "2 stars" },
          { y: data[1], label: "1 stars" },
          { y: data[0], label: "0 stars" },
        ]
      }]
    });
          
    this.chart.render();
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.user = user;
        this.src="https://localhost:8443/images/users/image-" + user?.id + ".jpg";
        this.empty = this.user.posts.length==0;
        this.userPosts = this.user.posts.slice(0,9);
      },
      error => console.log(error)
    );
  }  

  canUserRate(){
    return false;
  }

  getGraph(id:number){
    this.graphicsService.getGraphic(id).subscribe(
      graph => {
        this.chartData=graph;
        this.createGraph(this.chartData); 
      },
      error => console.log(error)
    );
  }

  updateRate(){
  }

}
