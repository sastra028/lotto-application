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

    
  billLists:any = [
    {billId: 1, name: 'A'},
    {billId: 2, name: 'B'},

  ];

  billList:any = [
    {
      billId: 1, 
      name: 'ป้านุ', 
      update: '17/02/2022-12:33', 

      listTwoUpTotal: "200",
      listTwoUpPrize: "100",

      listTwoDownTotal: "200",
      listTwoDownPrize: "2000",

      listThreeDirectTotal: "200",
      listThreeDirectPrize: "200",

      listThreeToteTotal: "200",
      listThreeTotePrize: "200",

      listTotal: "20000",
      prizeTotal: "10000",
      listTwoUp:[
        {
          number:"02",
          price:"20",
          prize: false
        },
        {
          number:"03",
          price:"20",
          prize: true
        }
      ],
      listTwoDown:[
        {
          number:"02",
          price:"20",
          prize: false
        },
        {
          number:"03",
          price:"20",
          prize: true
        }
      ],
      listThreeDirect:[
        {
          number:"159",
          price:"100",
          prize: false
        },
        {
          number:"657",
          price:"100",
          prize: false
        }
      ],
      listThreeTote:[
        {
          number:"935",
          price:"50",
          prize: false
        },
        {
          number:"864",
          price:"50",
          prize: false
        }
      ],
  
    },
    
    {
      billId: 2, 
      name: 'ป้านะ', 
      update: '17/02/2022-12:33', 

      listTwoUpTotal: "200",
      listTwoUpPrize: "100",

      listTwoDownTotal: "200",
      listTwoDownPrize: "2000",

      listThreeDirectTotal: "200",
      listThreeDirectPrize: "200",

      listThreeToteTotal: "200",
      listThreeTotePrize: "200",

      listTotal: "20000",
      prizeTotal: "10000",
      listTwoUp:[
        {
          number:"02",
          price:"20",
          prize: false
        },
        {
          number:"03",
          price:"20",
          prize: true
        }
      ],
      listTwoDown:[
        {
          number:"02",
          price:"20",
          prize: false
        },
        {
          number:"03",
          price:"20",
          prize: true
        }
      ],
      listThreeDirect:[
        {
          number:"159",
          price:"100",
          prize: false
        },
        {
          number:"657",
          price:"100",
          prize: false
        }
      ],
      listThreeTote:[
        {
          number:"935",
          price:"50",
          prize: false
        },
        {
          number:"864",
          price:"50",
          prize: false
        }
      ],
  
  
    }

  ];

  classnamecurrent:any;
  translatS: any;
  
  formSearch:any = {};
  classes:any = [];


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

  
  async onScrollDownFreesearch(ev: any) {

  }

  async filterFreesearch(){

  }
  select(item:any) {

  }

  getCourseName(item:any) {

  }

  toDisplayYear(year:any) {

  }
}
