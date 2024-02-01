import { Music } from './music';

describe('Music', () => {
  it('should create an instance', () => {
    expect(new Music( 1, "title", "description", "link", "image", new Date(), new Date())).toBeTruthy();
  });
});
