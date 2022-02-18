import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListThreeNightComponent } from './list-three-night.component';

describe('ListThreeNightComponent', () => {
  let component: ListThreeNightComponent;
  let fixture: ComponentFixture<ListThreeNightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListThreeNightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListThreeNightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
