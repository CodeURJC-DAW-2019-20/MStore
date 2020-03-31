import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ImageService } from 'src/app/services/image.service';
import { UserService } from 'src/app/services/user.service';
import { PostsService } from 'src/app/services/posts.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/models/user.model';
import { Post } from 'src/app/models/post.model';

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

  constructor(private userService:UserService, private loggedUserService: AuthenticationService, 
              private postsService:PostsService, private imageService:ImageService, private router: Router) {
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

  onFileChanged(event) {
    this.files.push(event.target.files[0]);
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
        post => { 
            this.post=post;
            this.loadImages(this.files.length,0);
            this.router.navigate(['/']);
        },
        error => console.log(error)
      );
    }
  }

  loadImages(nImg:number,img:number){
    let data  = new FormData();
    if(nImg>0){
      data.append("imagenFile",this.files[img]);
      this.imageService.addPostImage(this.post.id,data).subscribe(
        _ => this.loadImages(nImg-1,img+1),
        error => console.log(error)
      );
    }    
  }
}
