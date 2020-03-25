import { Component } from '@angular/core';

interface User{
  firstName:string;
  lastName:string;
  email:string;
  userAddress?:string;
  password:string;
  phone:number;
  creditCard?:number;
}

interface Post{
  postAddress:string;
  name:string;
  component:string;
  brand:{
    name:string;
  }
  //tags:string[];
  price:number;
  details:string;
  features?:string;
}

@Component({
  templateUrl: './app.createPostComponent.html',
  styleUrls: []
})
export class createPostComponent {

  user:User;
  post:Post;

  constructor() {
   this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com', password:"hola",phone:654432987};
  }

}
