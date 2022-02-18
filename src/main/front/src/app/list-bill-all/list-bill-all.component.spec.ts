import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBillAllComponent } from './list-bill-all.component';

describe('ListBillAllComponent', () => {
  let component: ListBillAllComponent;
  let fixture: ComponentFixture<ListBillAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBillAllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBillAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
