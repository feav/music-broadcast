import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MusicDistributionService } from './music-distribution.service';
import { Music } from '../../class/music/music';

describe('MusicDistributionService', () => {
  let service: MusicDistributionService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],  // Assurez-vous que HttpClientTestingModule est importé ici
      providers: [MusicDistributionService]
    });

    service = TestBed.inject(MusicDistributionService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch paginated music', () => {
    const page = 1;
    const pageSize = 10;
    const dummyMusic: Music[] = [
      // your dummy data here
    ];

    service.getMusicPagginated(page, pageSize).subscribe((music: Music[]) => {
      expect(music).toEqual(dummyMusic);
    });

    const req = httpTestingController.expectOne(`http://127.0.0.1:9091/api/v1/productions/?page?page=${page}&pageSize=${pageSize}`);
    expect(req.request.method).toEqual('GET');

    req.flush(dummyMusic);
  });

  it('should fetch all music', () => {
    const dummyMusic: Music[] = [
      // your dummy data here
    ];

    service.getMusic().subscribe((music: Music[]) => {
      expect(music).toEqual(dummyMusic);
    });

    const req = httpTestingController.expectOne('http://127.0.0.1:9091/api/v1/productions/?');
    expect(req.request.method).toEqual('GET');

    req.flush(dummyMusic);
  });
});
