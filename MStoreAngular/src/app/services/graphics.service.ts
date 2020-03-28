import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

const GRAPHICS_URL = "https://localhost:8443/api/graphics/";

@Injectable({ providedIn: 'root' })
export class GraphicsService {

	constructor(private httpClient: HttpClient) { }

	getGraphic(id:number): Observable<number[]> {
		return this.httpClient.get(GRAPHICS_URL+id).pipe(			
			catchError(error => this.handleError(error))
		) as Observable<number[]>;	
	}

	private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}

}