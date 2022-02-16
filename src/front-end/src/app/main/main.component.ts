import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { FormControl } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import {MatTableDataSource} from '@angular/material/table';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

// const ELEMENT_DATA: PeriodicElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
//   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
//   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
//   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
//   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
//   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
//   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
//   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
//   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
//   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
// ];

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(
    private apiService: ApiService,
  ) { }

  rows = [];

  detailData: {
    number: String,
    priceA: String,
    priceB: String,
  } = {
    number: '',
    priceA: '',
    priceB: '',
  };

  coursecodeControl :any = new FormControl();
  number :any
  ngOnInit(): void {
    this.getList2();
    this.getList3();
  }

  displayedColumns: string[] = ['number', 'up', 'down'];
  dataSource = [];

  dataSourceThree = [];
  dataSourceThree0 = [];
  dataSourceThree1 = [];
  dataSourceThree2 = [];
  dataSourceThree3 = [];
  dataSourceThree4 = [];
  dataSourceThree5 = [];
  dataSourceThree6 = [];
  dataSourceThree7 = [];
  dataSourceThree8 = [];
  dataSourceThree9 = [];

  displayedThreeColumns: string[] = ['number', 'direct', 'tote'];
  // displayedThreeColumnsNew: string[] = ['number', 'up', 'down'];

  onKeydown(event: any) {
    if (event.key === "Enter") {
      console.log(event);
    }
    console.log('sss');
  }

  save(){
    this.apiService.lottoSave2(this.detailData)
    .subscribe( {
      next: async (response) => {
        console.log('success');
        this.getList2();
        this.getList3();
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

  
  getList3(){
    this.apiService.getList3Main({
      main: "0"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree0 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "1"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree1 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "2"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree2 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "3"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree3 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "4"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree4 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "5"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree5 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "6"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree6 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "7"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree7 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "8"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree8 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });

    this.apiService.getList3Main({
      main: "9"
    })
    .subscribe({next: (results:any) => {
        this.dataSourceThree9 = results;
      },
      error: (err) => { console.log(err);},
      complete: () => { }
    });
    

  }

}
