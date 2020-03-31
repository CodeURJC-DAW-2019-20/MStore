import { Component } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GraphicsService } from 'src/app/services/graphics.service';
import { User } from 'src/app/models/user.model';
import { Image } from 'src/app/models/image.model';

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

  constructor(private userService:UserService, private graphicsService:GraphicsService, private loggedUserService: AuthenticationService) {
  }

  ngOnInit() {
    this.canRate=false;
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
    this.id=this.loggedUserService.currentUserValue.id;
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
