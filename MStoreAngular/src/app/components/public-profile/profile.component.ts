import { Component } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import {User} from 'src/app/models/user.model';

@Component({
  templateUrl: './profile.component.html',
  styleUrls: []
})
export class ProfileComponent {

  user:User;
  src:string;
  chart:CanvasJS.Chart;
  chartData:number[] = [3,4,9,2,0,1];
  canRate:boolean;

  constructor(private activatedRoute:ActivatedRoute, private userService:UserService) {
    this.getUser(activatedRoute.snapshot.params['id']);
  }

  ngOnInit() {
    this.createGraph(this.chartData);    
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
          { y: data[0], label: "5 stars" },
          { y: data[1], label: "4 stars" },
          { y: data[2], label: "3 stars" },
          { y: data[3], label: "2 stars" },
          { y: data[4], label: "1 stars" },
          { y: data[5], label: "0 stars" },
        ]
      }]
    });
          
    this.chart.render();
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.user=user;
        this.canRate= this.isLoggedUser()&&this.canUserRate();
      },
      error => console.log(error)
    );
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  canUserRate(){
    return true;
  }

  isLoggedUser(){
    return true;
  }

  updateRate(){
    this.canRate=false;
  }
}
