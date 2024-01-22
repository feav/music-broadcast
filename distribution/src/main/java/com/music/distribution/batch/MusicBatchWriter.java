package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class MusicBatchWriter implements ItemWriter<Music> {
    private static final Logger log = LoggerFactory.getLogger(MusicBatchWriter.class);

    @Override
    public void write(Chunk<? extends Music> chunk) throws Exception {
        chunk.forEach( music -> {
            log.info("Adding Person { " + music + " } ");
        } );
    }
}