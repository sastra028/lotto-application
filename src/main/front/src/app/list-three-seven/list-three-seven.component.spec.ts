import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeSevenComponent } from './list-three-seven.component';

describe('ListThreeSevenComponent', () => {
  let component: ListThreeSevenComponent;
  let fixture: ComponentFixture<ListThreeSevenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeSevenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeSevenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
