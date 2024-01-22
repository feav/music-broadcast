package com.music.distribution.implement;

import com.music.distribution.entity.Music;
import com.music.distribution.exception.NotFoundEntityException;
import com.music.distribution.repository.MusicRepository;
import com.music.distribution.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicRepository musicRepository;
    @Override
    public Music save(Music music) {
        return this.musicRepository.save(music);
    }

    @Override
    public Music update(Music music) {
        return this.musicRepository.save(music);
    }

    @Override
    public Music get(Long id)  throws NotFoundEntityException  {
        return this.musicRepository.getReferenceById(id);
    }

    @Override
    public List<Music> getAll() {
        return this.musicRepository.findAll();
    }

    @Override
    public void delete(Music music) throws NotFoundEntityException {
         this.musicRepository.delete(music);
    }
}
