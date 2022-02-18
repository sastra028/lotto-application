import { Component, OnInit } from '@angular/core';
import { Router} from "@angular/router";
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-list-main',
  templateUrl: './list-main.component.html',
  styleUrls: ['./list-main.component.css']
})
export class ListMainComponent implements OnInit {

  tabIndex:any;
  tabData:any;

  detailData: {
    number: String,
    priceA: String,
    priceB: String,
  } = {
    number: '',
    priceA: '',
    priceB: '',
  };

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

  constructor(
    private router: Router,
    private apiService: ApiService,
  ) { 
    if(localStorage.getItem("CURRENT_JWT") == null){
      this.router.navigate(['/list-main']);
    }

    const navigate = this.router.getCurrentNavigation()?.extras.state;
    if(navigate){
      this.tabData = navigate;
      this.tabIndex = this.tabData.tabIndex;
    }else{
      this.tabIndex = 0;
    }

  }
  ngOnInit(): void {
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
