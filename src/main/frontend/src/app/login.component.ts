import {Component, OnInit} from '@angular/core';
import {Router} from  '@angular/router';


import {AuthService} from './auth.service';
import {User} from './user';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  providers: [AuthService]
})

export class LoginComponent{

  user: User;
  error: Error;
  model = new User(1,2, 'Iulia','Danea', 'Iuli','email','parola');
  submitted = false;

  constructor(private authService: AuthService, private router: Router){}

  onSubmit(form){
    console.log(form.username,form.pass);

    this.authService.getUser(form.username,form.pass).subscribe(user=>this.user=user, err => this.error = err);
    if(this.error){
      console.log("not", this.error);
      this.router.navigate(['/login']);
    }
    else{
      console.log("ok",this.error);
        this.router.navigate(['/presentations']);
    }

  }
  //onSubmit() { this.submitted = true; }
  newHero() {
    this.model = new User(1,2, '', '','','','');
  }

}
