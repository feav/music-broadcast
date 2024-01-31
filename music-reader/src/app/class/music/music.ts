export class Music {
    id: number;
    title: string;
    description: string;
    link: string;
    image: string;
    createdAt: Date;
    pubDate: Date;
  
    constructor(id: number, title: string, description: string, link: string, image: string, createdAt: Date, pubDate: Date) {
      this.id = id;
      this.title = title;
      this.description = description;
      this.link = link;
      this.image = image;
      this.createdAt = createdAt;
      this.pubDate = pubDate;
    }
  }
  