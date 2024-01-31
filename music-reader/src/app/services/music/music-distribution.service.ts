import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Music } from '../../class/music/music';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicDistributionService {
  url = "http://127.0.0.1:9091/api/v1/productions/?";
  
  getMusicPagginated(page: number, pageSize: number) : Observable<Music[]> {
    const apiUrl = `${this.url}page?page=${page}&pageSize=${pageSize}`;
    return this.httpClient.get<Music[]>(apiUrl);
  }

  constructor(private httpClient: HttpClient) { }
  getMusic() : Observable<Music[]>{
    return this.httpClient.get<Music[]>(this.url);
  }
}
