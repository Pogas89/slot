import { TestBed } from '@angular/core/testing';

import { SlotmachineService } from './slotmachine.service';

describe('SlotmachineService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SlotmachineService = TestBed.get(SlotmachineService);
    expect(service).toBeTruthy();
  });
});
