import { Component } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { ActivatedRoute } from '@angular/router';

interface User{
  firstName:string;
  lastName:string;
  email:string;
  phone:number;
}

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

  constructor(private activatedRoute:ActivatedRoute) {

    this.getUser(activatedRoute.snapshot.params['id']);
  }

  ngOnInit() {
    this.canRate= this.isLoggedUser()&&this.canUserRate();
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
    this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com',phone:654432987};
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
