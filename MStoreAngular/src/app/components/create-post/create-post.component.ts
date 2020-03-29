import { Component } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { Post } from 'src/app/models/post.model';
import { UserService } from 'src/app/services/user.service';
import { PostsService } from 'src/app/services/posts.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  templateUrl: './create-post.component.html',
  styleUrls: []
})
export class CreatePostComponent {

  user:User;
  post:Post;
  src:string;
  files:File[]=[];
  submitted: boolean = false;

  constructor(private userService:UserService, private loggedUserService: AuthenticationService, private postsService:PostsService) {
    this.getUser(this.loggedUserService.currentUserValue.id);
    this.post = {postAddress: '', name: '', component: '', brand: {name:''}, price: 0,
    tags:[],details: ''};
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.user = user;
      },
      error => console.log(error)
    );
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  onFileChanged(event,index:number) {
    this.files[index] = event.target.files[0];
  }

  notvalid(){
    return (this.post.name == '' || this.post.postAddress == '' || this.post.component == '' || this.post.brand.name == '' || this.post.details == '');
  }

  onSubmit() {
    // upload code goes here
    if (this.notvalid()){
      this.submitted = true;
    }else{
      this.postsService.addPost(this.post).subscribe(
        post => console.log("hola"),
        error => console.log(error)
      );
    }
    
  }
}
