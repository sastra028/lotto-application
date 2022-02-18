import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeZeroComponent } from './list-three-zero.component';

describe('ListThreeZeroComponent', () => {
  let component: ListThreeZeroComponent;
  let fixture: ComponentFixture<ListThreeZeroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeZeroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeZeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
