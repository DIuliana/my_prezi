import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import 'rxjs/add/operator/map';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import {PresentationsComponent} from './presentations.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'presentations', component: PresentationsComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PresentationsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
