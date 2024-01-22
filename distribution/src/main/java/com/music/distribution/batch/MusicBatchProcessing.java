package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEntry;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class MusicBatchProcessing implements ItemProcessor<SyndEntry, Music> {
    private static final Logger log = LoggerFactory.getLogger(ItemProcessor.class);

    @Override
    public Music process(SyndEntry item) throws Exception {
        log.info("IMPORT ====> Converting ( " + item + " )");
        return new Music();
    }
}
