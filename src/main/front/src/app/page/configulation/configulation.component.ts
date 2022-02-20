import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-configulation',
  templateUrl: './configulation.component.html',
  styleUrls: ['./configulation.component.css']
})
export class ConfigulationComponent implements OnInit {

  constructor() { }

  animalControl = new FormControl('', Validators.required);
  selectFormControl = new FormControl('', Validators.required);
  animals= [
    {name: 'Dog', sound: 'Woof!'},
    {name: 'Cat', sound: 'Meow!'},
    {name: 'Cow', sound: 'Moo!'},
    {name: 'Fox', sound: 'Wa-pa-pa-pa-pa-pa-pow!'},
  ];


  formSearch:any = {};

  ngOnInit(): void {
  }
  loadData(){

  }

}
