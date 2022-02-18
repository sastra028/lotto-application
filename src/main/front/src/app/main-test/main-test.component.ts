import { Component, OnInit } from '@angular/core';
import { Router} from "@angular/router";

@Component({
  selector: 'app-main-test',
  templateUrl: './main-test.component.html',
  styleUrls: ['./main-test.component.css']
})
export class MainTestComponent implements OnInit {

  tabIndex:any;
  tabData:any;

  constructor(
    private router: Router
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

  login(){

  }

}
