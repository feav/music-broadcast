package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Component
public class MusicBatchProcessing implements ItemProcessor<SyndEntry, Music> {
    private static final Logger log = LoggerFactory.getLogger(ItemProcessor.class);
    String getImage(List<SyndEnclosure> enclosures){
        String img = "";
        for(SyndEnclosure enclosure : enclosures){


        }
        return img;
    }
    public static String limiterLength(String input, int maxLength) {
        if (input.length() > maxLength) {
            return input.substring(0, maxLength);
        }
        return input;
    }
    @Override
    public Music process(SyndEntry item)  {
        log.info("IMPORT ====> Converting ( " + item.getTitle() + " )");
        Music music = Music.builder()
                .createdAt(new Date())
                .link(item.getLink())
                .description(this.limiterLength(item.getDescription().getValue(),1000))
                .pubDate(item.getPublishedDate())
                .title(item.getTitle())
                .image(this.getImage(item.getEnclosures())).build();
        return music;
    }
}
