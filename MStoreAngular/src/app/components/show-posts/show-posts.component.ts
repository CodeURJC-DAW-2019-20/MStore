import { Component,Input } from '@angular/core';


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

    @Input() posts:Array<Post>;
    @Input() title?:string;
    images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

}