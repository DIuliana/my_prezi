import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import{Presentation} from './presentation';

@Injectable()
export class PresentationService{

  constructor(private http: Http){}

  getPresentations2():Observable<Presentation []>{

    return this.http.get('/users/2/presentations').map((res:Response) => res.json());
  }

    getPresentations(){

      return ["lalala","ptehhe"];
    }

}
