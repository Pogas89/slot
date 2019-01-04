import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotmachineAddComponent } from './slotmachine-add.component';

describe('SlotmachineAddComponent', () => {
  let component: SlotmachineAddComponent;
  let fixture: ComponentFixture<SlotmachineAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotmachineAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotmachineAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
