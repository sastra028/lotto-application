import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBillCardComponent } from './list-bill-card.component';

describe('ListBillCardComponent', () => {
  let component: ListBillCardComponent;
  let fixture: ComponentFixture<ListBillCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBillCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBillCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
