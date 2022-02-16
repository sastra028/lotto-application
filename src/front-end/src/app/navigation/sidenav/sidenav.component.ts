import { Component, ViewChild, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router, RouterEvent } from '@angular/router';
import { FlatTreeControl } from '@angular/cdk/tree';
import { MatTreeFlatDataSource, MatTreeFlattener } from '@angular/material/tree';
import { MatSidenav } from '@angular/material/sidenav';
import { MatDialog } from "@angular/material/dialog";

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  classname?:string;
  teacher:any;
  officerid?:string;
  result:any;
  tabData:any;
  tabIndex:any;
  teacherName: any;

  constructor(
    private router: Router,
    private dialog: MatDialog){

      if(localStorage.getItem("CURRENT_JWT") == null){
        this.router.navigate(['/login']);
      }

      const navigate = this.router.getCurrentNavigation()?.extras.state;
      if(navigate){
        this.tabData = navigate;
        this.tabIndex = this.tabData.tabIndex;
      }else{
        this.tabIndex = 0;
      }

    }
  openLanguageSelected(){

  }

  getCurrentRoute() {
    return this.router.url;
  }

  ngOnInit(): void {

  }

  logOut(){

  }
}
