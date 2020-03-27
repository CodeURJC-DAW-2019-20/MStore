import { Component } from '@angular/core';
import { Button } from 'protractor';

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
  templateUrl: './create-post.component.html',
  styleUrls: []
})
export class CreatePostComponent {

  user:User;
  post:Post;
  src:string;
  files:File[]=[];
  
  constructor() {
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
    this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com', password:"hola",phone:654432987};
  }

  onFileChanged(event,index) {
    this.files[index] = event.target.files[0];
  }

  onUpload() {
    // upload code goes here
  }
}
