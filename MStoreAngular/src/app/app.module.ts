import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TagInputModule } from 'ngx-chips';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopComponent } from './components/shop/shop.component';
import { PostComponent } from './components/post/post.component';
import { CartComponent } from './components/cart/cart.component';
import { ProfileComponent } from './components/public-profile/profile.component';
import { MyProfileComponent } from './components/public-profile/my-profile.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { CreatePostComponent } from './components/create-post/create-post.component';
import { IndexComponent } from './components/index/index.component';
import { ErrorInterceptor } from './components/error/error-interceptor.component';
import { ErrorComponentNF } from './components/error/errorNF.component';
import { LoginComponent } from './components/login/login.component';
import { IconsModule } from './modules/icons/icons.module';
import {ShowPostsComponent} from './components/show-posts/show-posts.component';
import { PaymentComponent } from './components/payment/payment.component';
import { StepperComponent } from './components/stepper/stepper.component';
import { FinalReviewComponent } from './components/final-review/final-review.component';
import { CompleteComponent } from './components/complete/complete.component';
import { AdminComponent } from './components/admin/admin.component';
import { BasicAuthInterceptor } from './helpers/basic-auth.interceptor';
import { ErrorComponent500 } from './components/error/error500.component';
import { ErrorComponent403 } from './components/error/error403.component';
import { HeaderComponent } from './components/header/header.component';
import { LoaderComponent } from './loader/loader.component';

// loader
import { LoaderService } from './services/loader.service';
import { LoaderInterceptor } from './services/loader.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    PostComponent,
    CartComponent,
    ProfileComponent,
    MyProfileComponent,
    EditProfileComponent,
    CreatePostComponent,
    IndexComponent,
    ErrorComponentNF,
    ErrorComponent500,
    ErrorComponent403,
    LoginComponent,
    ShowPostsComponent,
    PaymentComponent,
    StepperComponent,
    FinalReviewComponent,
    CompleteComponent,
    AdminComponent,
    HeaderComponent,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    IconsModule,
    TagInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule
  ],
  providers: [
    LoaderService,
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true},
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
