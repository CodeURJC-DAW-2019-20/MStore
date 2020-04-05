import { Component, NgZone, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { User } from 'src/app/models/user.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { PostsService } from 'src/app/services/posts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output()
  show = new EventEmitter();

  @Output()
  filterTags = new EventEmitter<{id: number, search: string}>();

  @Input()
  length: number;

  @Input()
  total: number;

  //Info usuario 
  user: User;
  isLogged: boolean;
  isAdmin: boolean;

  //Buscador
  posts: string[];
  searching: boolean;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private postService: PostsService) {
  }

  ngOnInit() {
    this.isLogged = this.authenticationService.isUserLog();
    if (this.isLogged) {
      this.user = this.authenticationService.currentUserValue;
      if (this.user != undefined)
        this.isAdmin = this.user.roles.includes("ROLE_ADMIN");
    }
  }

  logOut() {
    this.authenticationService.logout();
    this.router.navigate(['']).then(_ =>
      window.location.reload()
    );
  }

  openCart() {
    this.show.emit();
  }

  showSearchResults(event: any, name: string) {
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

  onSubmit(name: string) {
    if (name === '') {
      return;
    }
    this.postService.getPost(name).subscribe(
      post => this.router.navigate(['/post/' + post.id]),
      error => {
        console.log(error)
        alert("Product not found");
      }
    );
  }

  changePosts(idPost: number, searchPost: string) {
    this.filterTags.emit({id: idPost, search: searchPost});
  }

}