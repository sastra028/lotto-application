import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-bill-card-test',
  templateUrl: './list-bill-card-test.component.html',
  styleUrls: ['./list-bill-card-test.component.css']
})
export class ListBillCardTestComponent implements OnInit {

  constructor() { }
  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;
  ngOnInit(): void {
  }

}
