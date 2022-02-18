import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeTwoComponent } from './list-three-two.component';

describe('ListThreeTwoComponent', () => {
  let component: ListThreeTwoComponent;
  let fixture: ComponentFixture<ListThreeTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeTwoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
