import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tabIndex:any;
  tabData:any;

  dataSource = [];

  constructor(
    private router: Router,
  ) { 
    if(localStorage.getItem("CURRENT_JWT") == null){
      this.router.navigate(['/home']);
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
  
  opened = false

}
