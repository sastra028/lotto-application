import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-bill-all',
  templateUrl: './list-bill-all.component.html',
  styleUrls: ['./list-bill-all.component.css']
})
export class ListBillAllComponent implements OnInit {

  sessionHistory:any = [];
  
  constructor() { }

  ngOnInit(): void {
  }

  async onScrollDownHistory(ev: any) {

  }

}
