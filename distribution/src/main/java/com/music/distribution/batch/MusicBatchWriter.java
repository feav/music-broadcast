package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.music.distribution.exception.CreatedException;
import com.music.distribution.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicBatchWriter implements ItemWriter<Music> {
    private static final Logger log = LoggerFactory.getLogger(MusicBatchWriter.class);
    @Autowired
    private MusicService musicService;
    @Override
    public void write(Chunk<? extends Music> chunk) throws Exception {
        chunk.forEach( music -> {
            log.info("Adding Person { " + music + " } " + music.getDescription().length());
            try {
                musicService.save(music);
            } catch (CreatedException e) {
                log.error("Error Adding Person { " + music.getTitle() + " } ");
            }
        } );
    }
}