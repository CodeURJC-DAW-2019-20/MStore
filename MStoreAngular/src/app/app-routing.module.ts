import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { postComponent } from './app.postComponent';
import { shopComponent } from './app.shopComponent';


const routes: Routes = [
  { path: 'post/:id', component: postComponent, },
  { path: 'shop', component: shopComponent, }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);