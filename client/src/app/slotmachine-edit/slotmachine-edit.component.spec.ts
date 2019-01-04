import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotmachineEditComponent } from './slotmachine-edit.component';

describe('SlotmachineEditComponent', () => {
  let component: SlotmachineEditComponent;
  let fixture: ComponentFixture<SlotmachineEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotmachineEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotmachineEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
