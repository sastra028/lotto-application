import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeTenComponent } from './list-three-ten.component';

describe('ListThreeTenComponent', () => {
  let component: ListThreeTenComponent;
  let fixture: ComponentFixture<ListThreeTenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeTenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeTenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
