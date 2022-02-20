import { Component, OnInit } from '@angular/core';

import { ApiService } from 'src/app/services/api.service';
import { AlertDialogComponent } from 'src/app/component/alert-dialog/alert-dialog.component';
import { MatDialog } from "@angular/material/dialog";
@Component({
  selector: 'app-list-two',
  templateUrl: './list-two.component.html',
  styleUrls: ['./list-two.component.css']
})


export class ListTwoComponent implements OnInit {

  loadingspin = false;
  formSearch:any = {};
  classes:any = [];

  
  limitforhistory = 0;

  // billList:any= [];
  islangThai?:boolean;
  detailData: {
    number: String,
    priceA: String,
    priceB: String,
    buyerName: String,
    sellerName: String,
  } = {
    number: '',
    priceA: '',
    priceB: '',
    buyerName: '',
    sellerName: '',
  };

  billLists:any = [
    {billId: 1, name: 'A'},
    {billId: 2, name: 'B'},

  ];
  // billList:any= [];

  reportTwo:any = {
    list: [
      {
        number:"01",
        up:"2000",
        down:"3000",
        upLimit:"2000",
        downLimit:"2000",
        upMax:true,
        downMax:true,
      },
      {
        number:"02",
        up:"3000",
        down:"2000",
        upLimit:"3000",
        downLimit:"3000",
        upMax:true,
        downMax:false,
      },
      {
        number:"03",
        up:"3000",
        down:"4000",
        upLimit:"25000",
        downLimit:"5000",
        upMax:false,
        downMax:true,
      },
      {
        number:"04",
        up:"3000",
        down:"4000",
        upLimit:"2000",
        downLimit:"2000",
        upMax:true,
        downMax:true,
      },
      {
        number:"05",
        up:"3000",
        down:"4000",
        upLimit:"2000",
        downLimit:"2000",
        upMax:true,
        downMax:true,
      }
    ],
    sum: "40000",
    over: "2000"
  }
;

  twoList:any = [
    {
      number:"01",
      up:"2000",
      down:"3000",
      upMax:true,
      downMax:false
    },
    {
      number:"02",
      up:"3000",
      down:"4000",
      upMax:true,
      downMax:true
    }
  ];

  billList:any = [
    {
      billId: 1, 
      name: 'ป้านุ', 
      update: '17/02/2022-12:33', 

      twoUpTotal: "200",
      twoUpPrize: "0",

      twoDownTotal: "200",
      ltwoDownPrize: "0",

      threeDirectTotal: "200",
      threeDirectPrize: "0",

      threeToteTotal: "200",
      threeTotePrize: "0",

      priceTotal: "20000",
      prizeTotal: "0",
      listTwoUp:[
        {
          number:"02",
          price:"20",
          prize: false
        },
        {
          number:"03",
          price:"20",
          prize: false
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
          prize: false
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

  constructor(
    private apiService: ApiService,
    private dialog: MatDialog,) { }

  ngOnInit(): void {
    this.loadData();
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


  
  save(){
    
  }

  getBill(){
    
  }

  delete(applicationId: any){
    
  }

  confirm(buyerName: any){
    
  }

  unConfirm(buyerName: any){
    
  }

  loadData(){
    let param = {

    }
    this.apiService.getReportTwo(param)
    .subscribe( {
      next: async (results) => {
        console.log('results 2: '+results);
        this.reportTwo = results;
      },
      error: async (error) => {
        console.log(error);
      }
    });
  }

}
