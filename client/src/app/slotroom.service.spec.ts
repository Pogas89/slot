import { TestBed } from '@angular/core/testing';

import { SlotroomService } from './slotroom.service';

describe('SlotroomService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SlotroomService = TestBed.get(SlotroomService);
    expect(service).toBeTruthy();
  });
});
