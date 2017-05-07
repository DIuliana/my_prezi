import {Component} from '@angular/core';

import {PresentationService} from './presentation.service';
import {Presentation} from './presentation';

@Component({
  selector: 'presentations',
  templateUrl: './presentations.component.html',
  providers: [PresentationService]
})
export class PresentationsComponent {
  title: string = "Presentation title";
  presentations;
  prese:Presentation[];

  constructor(presentationService: PresentationService) {
    this.presentations = presentationService.getPresentations();

    // this.prese=presentationService.getPresentations2().subscribe(
    //   prese => this.prese = prese, //Bind to view
    //   err => {
    //     // Log errors if any
    //     console.log(err);
    //   });
    // }

  }
}
