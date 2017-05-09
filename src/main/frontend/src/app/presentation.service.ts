import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import{Presentation} from './presentation';

@Injectable()
export class PresentationService{

  private presentations_Url='/prezi/api/users/2/presentations';

  constructor(private http: Http){}

  getPresentations2(): Observable<Presentation[]>{

    return this.http.get(this.presentations_Url).map((response:Response)=><Presentation[]> response.json());
  }

    getPresentations(){

      return ["lalala","ptehhe"];
    }

}
