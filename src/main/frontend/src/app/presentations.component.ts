import {Component, OnInit} from '@angular/core';

import {PresentationService} from './presentation.service';
import {Presentation} from './presentation';

@Component({
  selector: 'presentations',
  templateUrl: './presentations.component.html',
  providers: [PresentationService]
})
export class PresentationsComponent implements OnInit{

  title: string = "Presentation title";
  presentations: Presentation[];

  constructor(private presentationService: PresentationService) {}

  ngOnInit():void{

    this.presentationService.getPresentations2().subscribe(presentations=>this.presentations=presentations);

  }


}
