import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigulationComponent } from './configulation.component';

describe('ConfigulationComponent', () => {
  let component: ConfigulationComponent;
  let fixture: ComponentFixture<ConfigulationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfigulationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigulationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
