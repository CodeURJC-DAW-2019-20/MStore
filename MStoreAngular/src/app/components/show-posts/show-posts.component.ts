import { Component,Input } from '@angular/core';
import { Router } from '@angular/router'; 


interface Post{
    id:number;
    name:string;
    price:number;
    description:string;
}
@Component({
  selector: 'app-posts',
  templateUrl: './show-posts.component.html',
  styleUrls: []
})
export class ShowPostsComponent {

  
  constructor(private router:Router){
  }

    @Input() posts:Array<Post>;
    @Input() title?:string;
    images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

    refresh(){
      window.location.reload();
    }
    navigate(id:number){
      this.router.navigate(['/post/'+id]).then(() => {
        window.location.reload();
      });
    }

}