import { Component, OnInit } from '@angular/core';
import { Router} from "@angular/router";
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-main-list',
  templateUrl: './main-list.component.html',
  styleUrls: ['./main-list.component.css']
})
export class MainListComponent implements OnInit {

  tabIndex:any;
  tabData:any;
  
  constructor(
    private router: Router,
    private apiService: ApiService,
  ) { 
    // if(localStorage.getItem("CURRENT_JWT") == null){
    //   this.router.navigate(['/list-main']);
    // }

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

}
