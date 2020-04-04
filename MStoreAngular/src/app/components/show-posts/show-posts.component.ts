import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/models/post.model';
@Component({
  selector: 'app-posts',
  templateUrl: './show-posts.component.html',
  styleUrls: ['./show-posts.component.css']
})
export class ShowPostsComponent {


  constructor(private router: Router) {
  }

  @Input() posts: Array<Post>;
  @Input() title?: string;

  refresh() {
    window.location.reload();
  }
  navigate(id: number) {
    this.router.navigate(['/post/' + id]).then(() => {
      window.location.reload();
    });
  }

}