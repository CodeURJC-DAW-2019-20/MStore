import { Component, OnInit } from '@angular/core';

interface post {
  id:number;
  name:string;
  description:string;
  }

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  title = 'MStoreAngular';
  Posts: Array<post> = [{id: 0, name: 'AMD card', description: 'new AMD card'},
  {id: 3, name: 'AMD card 2', description: 'new AMD card'},
  {id: 5, name: 'AMD card 3', description: 'new AMD card'},
  {id: 12, name: 'AMD card 4', description: 'new AMD card'},
  {id: 14, name: 'AMD card 5', description: 'new AMD card'},
  {id: 16, name: 'AMD card 6', description: 'new AMD card'}];

  constructor() { }

  ngOnInit(): void {
  }

}
