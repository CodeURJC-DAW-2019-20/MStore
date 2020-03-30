import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Brand } from '../models/brand.model';
import { catchError } from 'rxjs/operators';

const BRANDS_URL = "https://localhost:8443/api/brands/";

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private httpClient: HttpClient) { }

  getBrands(): Observable<Brand[]> {
    return this.httpClient
      .get(BRANDS_URL)
      .pipe(catchError(error => this.handleError(error))) as Observable<Brand[]>;
  }

  getBrand(id:number) {
    return this.httpClient
    .get(BRANDS_URL + id)
    .pipe(catchError(error => this.handleError(error))) as Observable<Brand>;
  }

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
}
