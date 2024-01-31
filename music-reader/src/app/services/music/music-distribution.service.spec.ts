import { TestBed } from '@angular/core/testing';

import { MusicDistributionService } from './music-distribution.service';

describe('MusicDistributionService', () => {
  let service: MusicDistributionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MusicDistributionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
