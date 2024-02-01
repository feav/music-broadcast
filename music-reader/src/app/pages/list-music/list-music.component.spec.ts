import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ListMusicComponent } from './list-music.component';
import { MusicDistributionService } from '../../services/music/music-distribution.service';
import { HttpClientModule } from '@angular/common/http';  
import { DefaultImagePipe } from '../../share/pipes/default-image/default-image.pipe';
import { TruncatePipe } from '../../share/pipes/truncate/truncate.pipe';
import { HttpTestingController } from '@angular/common/http/testing';

describe('ListMusicComponent', () => {
  let component: ListMusicComponent;
  let fixture: ComponentFixture<ListMusicComponent>;
  let musicServiceMock: jasmine.SpyObj<MusicDistributionService>;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    const mockMusicService = jasmine.createSpyObj('MusicDistributionService', ['getMusicPagginated', 'getMusic']);

    TestBed.configureTestingModule({
      providers: [
        { provide: MusicDistributionService, useValue: mockMusicService }
      ],
      declarations: [ ]
    }).compileComponents();

    fixture = TestBed.createComponent(ListMusicComponent);
    component = fixture.componentInstance;
    musicServiceMock = TestBed.inject(MusicDistributionService) as jasmine.SpyObj<MusicDistributionService>;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
