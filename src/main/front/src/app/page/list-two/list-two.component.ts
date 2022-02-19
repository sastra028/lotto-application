import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-two',
  templateUrl: './list-two.component.html',
  styleUrls: ['./list-two.component.css']
})
export class ListTwoComponent implements OnInit {

  loadingspin = false;
  formSearch:any = {};
  classes:any = [];

  constructor() { }

  ngOnInit(): void {
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
