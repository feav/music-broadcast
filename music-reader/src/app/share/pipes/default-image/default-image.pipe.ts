import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'defaultImage',
  standalone: true
})
export class DefaultImagePipe implements PipeTransform {

 
  transform(value: string): string {
    if (value === undefined || value === "") {
      return 'https://i.scdn.co/image/ab67706f00000002bf8a74338d1c77439855b61d';
    }
    return value;
  }

}
