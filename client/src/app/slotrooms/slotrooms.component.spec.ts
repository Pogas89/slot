import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlotroomsComponent } from './slotrooms.component';

describe('SlootroomsComponent', () => {
  let component: SlotroomsComponent;
  let fixture: ComponentFixture<SlotroomsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlotroomsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlotroomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
