import { Component, OnInit } from '@angular/core';
import { PostsService } from 'src/app/services/posts.service';
import { ImageService } from 'src/app/services/image.service';
import { Post } from 'src/app/models/post.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  index: number[];
  images: File[];
  imgsUrl: string[];
  posts: Array<string>;
  post: Post;

  searching: boolean;
  found: boolean;
  edit: boolean;
  remove: boolean;
  edited: boolean;

  constructor(
    private postService: PostsService, 
    private router: Router,
    private imageService: ImageService) {
  }

  ngOnInit(): void {
    this.searching = false;
    this.found = false;
    this.edit = false;
    this.remove = false;
    this.edited = false;

    this.index = [];
    this.imgsUrl = [];
    this.images = [];
    this.posts = [];
  }

  showSearchResults(event: any, name: string): void {
    if (event.target.value.length >= 3) {
      this.postService.getPostsByName(name).subscribe(
        posts => {
          this.posts = posts.map(post => post.name);
          if (this.posts.filter(namePost => namePost === name).length > 0) {
            this.searching = false;
          } else {
            this.searching = true;
          }
        },
        error => console.log(error)
      );
    } else {
      this.searching = false;
    }
  }

  loadImages(id: number) {
    this.imageService.getPostImages(id).subscribe(
      images => {
        let i = 0;
        images.forEach(img => {
          this.imgsUrl[i] = 'https://localhost:8443/images/posts/image-' + id + '-' + i + '.jpg';
          i++;
        });
      },
      error => console.log(error)
    );
  }

  onSubmit(name: string) {
    this.remove = false;
    this.edited = false;
    this.edit = false;
    if (name === '') {
      this.router.navigate(['/admin']).then(() => {
        this.found = false;
        alert("Product not found");
      });
      return;
    }
    this.postService.getPost(name).subscribe(
      post => {
        this.post = post;
        this.found = true;
        this.loadImages(post.id);
      },
      error => { 
        console.log(error)
        this.found = false;
        this.router.navigate(['/admin']).then(() => {
          alert("Product not found");
        });
      }
    );
  }

  onRemove(id: number) {
    this.postService.removePost(id).subscribe(
      _ => {
        this.post = undefined;
        this.found = false;
        this.edited = false;
        this.edit = false;
        this.remove = true;
      },
      error => console.log(error)
    );
  }

  onEdit() {
    this.edit = true;
    this.edited = false;
    this.index = [];
    this.images = [];
  }

  onEditProduct() {
    this.postService.updatePost(this.post).subscribe(
      post => {
        this.post = post;
        this.changeImages();
        this.edit = false;
        this.edited = true;
        this.loadImages(this.post.id);
      },
      error => console.log(error)
    );
  }

  onFileChanged(event: any, idImg: number) {
    this.images.push(event.target.files[0]);
    this.index.push(idImg);
  }

  changeImages() {
    let i: number = 0;
    for (let img of this.images) {
      if (typeof img.name !== 'string') {
        continue;
      }
      let data = new FormData();
      data.append("imagenFile",img);
      if (this.index.indexOf(Number(i))  >= this.post.nImg) {
        this.imageService.addPostImage(this.post.id,data).subscribe(
          error => console.log(error)
        );
      } else {
        this.imageService.updatePostImage(this.post.id,this.index.indexOf(Number(i)),data).subscribe(
          error => console.log(error)
        );
      }
      i++;
    }
   }   

}
