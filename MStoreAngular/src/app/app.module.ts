import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { shopComponent } from './app.shopComponent';
import { postComponent } from './app.postComponent';
import { cartComponent } from './cart/app.cartComponent';
import { profileComponent } from './publicProfile/app.profileComponent';
import { editProfileComponent } from './editProfile/app.editProfileComponent';
import { createPostComponent } from './createPost/app.createPostComponent';
import { indexComponent } from './index/app.indexComponent';
import { errorInterceptor } from './error/app.errorInterceptor';
import { errorComponentNF } from './error/app.errorComponentNF';
import { LoginComponent } from './login/login.component';
import { IconsModule } from './icons/icons.module';
import {ShowPostsComponent} from './showPosts/app.showPostsComponent';
import {finalreviewComponent} from './finalreview/app.finalreviewComponent';

@NgModule({
  declarations: [
    AppComponent,
    postComponent,
    shopComponent,
    cartComponent,
    profileComponent,
    editProfileComponent,
    createPostComponent,
    indexComponent,
    errorComponentNF,
    indexComponent,
    finalreviewComponent,
    LoginComponent,
    ShowPostsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    IconsModule
  ],
  providers: [      
    {provide: HTTP_INTERCEPTORS,
    useClass: errorInterceptor,
    multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
