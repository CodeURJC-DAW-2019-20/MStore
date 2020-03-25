import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
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
import { errorInterceptor } from './app.errorInterceptor';
import { errorComponentNF } from './app.errorComponentNF';
import { LoginComponent } from './login/login.component';
import { IconsModule } from './icons/icons.module';
import {finalreviewComponent} from './app.finalreviewComponent';

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
    LoginComponent
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
