import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeFourComponent } from './list-three-four.component';

describe('ListThreeFourComponent', () => {
  let component: ListThreeFourComponent;
  let fixture: ComponentFixture<ListThreeFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeFourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
