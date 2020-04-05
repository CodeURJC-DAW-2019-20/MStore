import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Brand } from '../../models/brand.model';
import { BrandService } from '../../services/brand.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  brands: Brand[];
  
  @Output()
  filterPosts = new EventEmitter<{id: number, search: string}>();

  constructor(private brandService: BrandService) { }

  ngOnInit(): void {
    this.getBrands();
  }

  getBrands() {
    this.brandService.getBrands().subscribe(
      response => {
        this.brands = response;
      },
      error => console.log(error)
    );
  }

  changePosts(idPost: number, searchPost: string) {
    this.filterPosts.emit({id: idPost, search: searchPost});
  }

}
