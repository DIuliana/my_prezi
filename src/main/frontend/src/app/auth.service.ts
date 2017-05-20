import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import{User} from './user';

@Injectable()
export class AuthService{

  private auth_base_Url='/prezi/api/auth/';

  constructor(private http: Http){}

  getUser(userName, pass): Observable<User>{

    this.auth_base_Url+=userName+"/"+pass;

    console.log("service auth", this.auth_base_Url);

    return this.http.get(this.auth_base_Url).map((response:Response)=><User> response.json()).catch((error: any) => {
      if (error.status === 400) {
        console.log("400;")
        return Observable.throw(new Error(error.status));
      }

    });
  }

}
