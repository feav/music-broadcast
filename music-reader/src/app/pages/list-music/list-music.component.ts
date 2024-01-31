import { Component, HostListener, OnInit } from '@angular/core';
import { Music } from '../../class/music/music';
import { MusicDistributionService } from '../../services/music/music-distribution.service';
import { HttpClientModule } from '@angular/common/http';
import { DefaultImagePipe } from '../../share/pipes/default-image/default-image.pipe';
import { TruncatePipe } from '../../share/pipes/truncate/truncate.pipe';

@Component({
  selector: 'app-list-music',
  standalone: true,
  imports: [TruncatePipe,DefaultImagePipe],
  templateUrl: './list-music.component.html',
  styleUrl: './list-music.component.scss'
})
export class ListMusicComponent implements OnInit  {
  musics: Music[] = [];
  
  page = 1;
  pageSize = 10;
  
  noMoreMusics = false;
  public constructor(private musicService:MusicDistributionService){
 
  }
  ngOnInit() {
    this.loadItems();
  }
  loadItems() {
    if(!this.noMoreMusics){
      console.log(this.musics)
      this.musicService.getMusicPagginated(this.page, this.pageSize).subscribe((data: any) => {
        if( data.content != undefined){
          this.musics = this.musics.concat(data.content);

          console.log(this.musics)
          if( data.totalPages < this.page)
            this.noMoreMusics = true;
        }
      });
    }
  }
  
  loadItemsAll() {
    this.musicService.getMusic().subscribe( 
      (datas : Music[]) => {
        this.musics = datas;
      } 
    );
  }
  @HostListener('window:scroll', ['$event'])
  onScroll(event: any) {
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
      if(this.musics.length == this.page*this.pageSize){
        this.page++;
        //this.loadItems();
      }
    }
  }
}
