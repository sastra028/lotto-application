import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-bill-card',
  templateUrl: './list-bill-card.component.html',
  styleUrls: ['./list-bill-card.component.css']
})
export class ListBillCardComponent implements OnInit {

  limitforhistory = 0;

  loadingspin = false;
  islangThai?:boolean;

  detailData: {
    number: String,
    priceA: String,
    priceB: String,
  } = {
    number: '',
    priceA: '',
    priceB: '',
  };

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

  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;
  

  classnamecurrent:any;
  translatS: any;
  constructor() { }

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
