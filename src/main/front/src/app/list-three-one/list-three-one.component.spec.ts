import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeOneComponent } from './list-three-one.component';

describe('ListThreeOneComponent', () => {
  let component: ListThreeOneComponent;
  let fixture: ComponentFixture<ListThreeOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeOneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
