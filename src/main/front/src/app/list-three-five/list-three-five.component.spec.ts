import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeFiveComponent } from './list-three-five.component';

describe('ListThreeFiveComponent', () => {
  let component: ListThreeFiveComponent;
  let fixture: ComponentFixture<ListThreeFiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeFiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeFiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
