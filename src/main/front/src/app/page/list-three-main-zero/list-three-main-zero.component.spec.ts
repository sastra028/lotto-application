import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeMainZeroComponent } from './list-three-main-zero.component';

describe('ListThreeMainZeroComponent', () => {
  let component: ListThreeMainZeroComponent;
  let fixture: ComponentFixture<ListThreeMainZeroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeMainZeroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeMainZeroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
