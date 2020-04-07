import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Rating } from 'src/app/models/rating.model';
import { AuthenticationService } from 'src/app/services/authentication.service';

const RATINGS_URL = "https://localhost:8443/api/ratings/";

@Injectable({ providedIn: 'root' })
export class RatingService {

	constructor(private httpClient: HttpClient, private authService:AuthenticationService) { }

	getRating(id:number): Observable<Rating> {
		return this.httpClient.get(RATINGS_URL+id).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<Rating>;	
	}

	addRating(rating:Rating): Observable<Rating> {
		return this.httpClient.post(RATINGS_URL, rating).pipe(			
			catchError(error => this.handleError(error))
		)as Observable<Rating>;
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}