import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBillCardTestComponent } from './list-bill-card-test.component';

describe('ListBillCardTestComponent', () => {
  let component: ListBillCardTestComponent;
  let fixture: ComponentFixture<ListBillCardTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBillCardTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBillCardTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
