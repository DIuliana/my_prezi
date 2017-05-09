import {Component, OnInit} from '@angular/core';
import {Router} from  '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./app.component.css']
})
export class LoginComponent {
  constructor(private router: Router){}
  authUser(userName:string, pass:string){

    console.log(userName);
    console.log(pass);

    //userService.auth
    if(userName=='lala'){
      console.log("ksksksk");

    }
  }

}
