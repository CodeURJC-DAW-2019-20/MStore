import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { postComponent } from './app.postComponent';
import { shopComponent } from './app.shopComponent';
import { cartComponent } from './app.cartComponent';
import { profileComponent } from './app.profileComponent';
import { editProfileComponent } from './app.editProfileComponent';
import { createPostComponent } from './app.createPostComponent';
import { indexComponent } from './app.indexComponent';

@NgModule({
  declarations: [
    AppComponent,
    postComponent,
    shopComponent,
    cartComponent,
    profileComponent,
    editProfileComponent,
    createPostComponent,
    indexComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
