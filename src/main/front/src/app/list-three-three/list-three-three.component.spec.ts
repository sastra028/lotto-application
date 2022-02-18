import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeThreeComponent } from './list-three-three.component';

describe('ListThreeThreeComponent', () => {
  let component: ListThreeThreeComponent;
  let fixture: ComponentFixture<ListThreeThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeThreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
