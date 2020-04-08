import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Brand } from '../../models/brand.model';
import { BrandService } from '../../services/brand.service';
import { HttpClient, HttpParams } from '@angular/common/http';

interface MailChimpResponse {
  result: string;
  msg: string;
}

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  brands: Brand[];
  
  @Output()
  filterPosts = new EventEmitter<{id: number, search: string}>();

  constructor(
    private brandService: BrandService,
    private http: HttpClient) { }

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

  onSubmit(email: string) {
    let urlStart = "https://urjc.us4.list-manage.com/subscribe/post-json?u=7816e91fc0e80c209c0a7750e&amp;id=a3e1cc1eb7&";

    const params = new HttpParams()
    .set('EMAIL', email);
    //.set('b_c7103e2c981361a6639545bd5_29ca296126', ''); // hidden input name

    const url = urlStart + params.toString();

    this.http.jsonp<MailChimpResponse>(url, 'c').subscribe(
      response => { 
        if (response.result === 'error' 
          && confirm(email + ' is already subscribed to our newsletter. Accept to update your profile')) {
            location.href = 'https://urjc.us4.list-manage.com/subscribe/send-email?e=bHVuc3NzZXNAZ21haWwuY29t&u=7816e91fc0e80c209c0a7750e&id=a3e1cc1eb7';
        } else if (response.result !== 'error') {
          alert(response.msg);
        }
      },
      error => console.log(error)
    );
  }

}
