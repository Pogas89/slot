import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotroomAddComponent } from './slotroom-add.component';

describe('SlotroomAddComponent', () => {
  let component: SlotroomAddComponent;
  let fixture: ComponentFixture<SlotroomAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotroomAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotroomAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
