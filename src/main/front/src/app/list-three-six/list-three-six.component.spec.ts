import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeSixComponent } from './list-three-six.component';

describe('ListThreeSixComponent', () => {
  let component: ListThreeSixComponent;
  let fixture: ComponentFixture<ListThreeSixComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeSixComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeSixComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
