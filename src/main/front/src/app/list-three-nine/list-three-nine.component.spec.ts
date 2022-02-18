import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeNineComponent } from './list-three-nine.component';

describe('ListThreeNineComponent', () => {
  let component: ListThreeNineComponent;
  let fixture: ComponentFixture<ListThreeNineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeNineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeNineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
