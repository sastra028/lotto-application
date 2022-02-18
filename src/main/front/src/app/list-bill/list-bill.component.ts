import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-list-bill',
  templateUrl: './list-bill.component.html',
  styleUrls: ['./list-bill.component.css']
})
export class ListBillComponent implements OnInit {

  displayedColumns: string[] = ['number', 'up', 'down'];
  dataSource = [];

  detailData: {
    number: String,
    priceA: String,
    priceB: String,
    buyerName: String,
  } = {
    number: '',
    priceA: '',
    priceB: '',
    buyerName: ''
  };

  constructor(
    private apiService: ApiService
    ) { }

  ngOnInit(): void {
  }

  
  save(){
    this.apiService.lottoSave2(this.detailData)
    .subscribe( {
      next: async (response) => {
        console.log('success');
        this.getList2();
        // this.getList3();
      },
      error: async (error) => {
        console.log('error');
      }
    });
  }

  getList2(){
    this.apiService.getList2()
    .subscribe( {
      next: async (results) => {
        console.log('results 2: '+results);
        this.dataSource = results;
      },
      error: async (error) => {
        console.log('error');
      }
    });
    
  }
  
  getBill(){
    this.apiService.getBill()
    .subscribe( {
      next: async (results) => {
        console.log('results 2: '+results);
        this.dataSource = results;
      },
      error: async (error) => {
        console.log('error');
      }
    });
  }

}
