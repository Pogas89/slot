import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotmachinesComponent } from './slotmachines.component';

describe('SlotmachinesComponent', () => {
  let component: SlotmachinesComponent;
  let fixture: ComponentFixture<SlotmachinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotmachinesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotmachinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
