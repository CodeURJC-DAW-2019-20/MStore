import { Component, OnInit, Output, EventEmitter } from '@angular/core';

interface User{
  firstName:string;
  lastName:string;
  email:string;
  userAddress?:string;
  password:string;
  phone:number;
  creditCard?:number;
}

@Component({
  selector: 'app-final-review',
  templateUrl: './final-review.component.html',
  styleUrls: ['./final-review.component.css']
})
export class FinalReviewComponent implements OnInit {

  @Output()
  previous2 = new EventEmitter();

  user={firstName:"Marcos",lastName:"Ruiz Muñoz",email:"mr@gmail.com",userAddress:"Miami Street",password:"mr",phone:"55478544",creditCard:"5645544"}
  cart=[{id: 1, name: 'AMD card', price:80,  description: 'new AMD card'},
  {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
  {id: 3, name: 'AMD card 3', price:50,  description: 'new AMD card'}];
  total=350;
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  constructor() { }

  ngOnInit(): void {
  }

  previous() {
    this.previous2.emit();
  }
  
}
