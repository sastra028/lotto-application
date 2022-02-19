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

  
  sessionHistory:any = [
    {coursecode: 1, name: 'A', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 2, name: 'B', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 3, name: 'C', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 4, name: 'D', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 5, name: 'E', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},
    {coursecode: 6, name: 'F', classnameeng: 1.0079, acadyear: '2565', classdate: '19/02/2022', classtime: '10:29'},

  ];

  classnamecurrent:any;
  translatS: any;
  
  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;

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
