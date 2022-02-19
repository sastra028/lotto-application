import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-bill',
  templateUrl: './list-bill.component.html',
  styleUrls: ['./list-bill.component.css']
})
export class ListBillComponent implements OnInit {

  constructor() { }

  limitforhistory = 0;

  loadingspin = false;
  islangThai?:boolean;

  sessionHistory:any = [];

  classnamecurrent:any;
  translatS: any;
  
  ngOnInit(): void {
  }

  

  
  getCurrentLang(){
    return 'th';
  }

  async classHistory(){
    
  }

  async onScrollDownHistory(ev: any) {
  }

  async openSession(session:any){

  }
}
