import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ImageService } from 'src/app/services/image.service';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/models/user.model';


@Component({
  templateUrl: './edit-profile.component.html',
  styleUrls: []
})
export class EditProfileComponent {

  user:User;
  userLog:User;
  confirmPass:string;
  src:string;
  file:File;
  submitted: boolean = false;

  constructor(private userService:UserService, private loggedUserService: AuthenticationService, 
              private imageService:ImageService, private router: Router) {
    this.getUser(this.loggedUserService.currentUserValue.id);
    this.user={id:0,firstName:'', lastName:'',
      email:'',phone:undefined,password:'',roles:[],
      userAddress:'',creditCard:undefined}
    this.file=undefined;
  }

  onFileChanged(event) {
    this.file = event.target.files[0];
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.userLog = user;
        this.user={id:this.userLog.id,firstName:this.userLog.firstName, lastName:this.userLog.lastName,
              email:this.userLog.email,phone:this.userLog.phone,password:'',roles:this.userLog.roles,
              userAddress:this.userLog.userAddress,creditCard:this.userLog.creditCard};
      },
      error => console.log(error)
    );
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  notvalid(){
    return (this.user.firstName == '' || this.user.lastName == '' || this.checkPhone());
  }

  checkPhone(){
    return <any>this.user.phone == '';
  }

  onSubmit() {
    // upload code goes here
    if (this.notvalid()){
      this.submitted = true;
    }else{
      this.userService.updateUser(this.user,this.user.id).subscribe(
        _ => this.router.navigate(['/']),
        error => console.log(error)
      );
      if(this.file != undefined){
        const data  = new FormData();
        data.append("imagenFile",this.file);
        this.imageService.updateUserImage(this.user.id,data).subscribe(
          _ => console.log("hola"),
          error => console.log(error)
        );
      }
    }
    
  }
}
