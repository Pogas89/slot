import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotroomEditComponent } from './slotroom-edit.component';

describe('SlotroomEditComponent', () => {
  let component: SlotroomEditComponent;
  let fixture: ComponentFixture<SlotroomEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotroomEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotroomEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
