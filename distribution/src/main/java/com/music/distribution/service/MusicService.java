package com.music.distribution.service;

import com.music.distribution.entity.Music;
import com.music.distribution.exception.CreatedException;
import com.music.distribution.exception.NotFoundEntityException;
import com.music.distribution.exception.UpdatedException;

import java.util.List;

public interface MusicService {
    Music save(Music music) throws CreatedException;
    Music update(Music music) throws UpdatedException;
    Music get(Long id) throws NotFoundEntityException;
    List<Music> getAll();
    void delete(Music music) throws NotFoundEntityException;
}