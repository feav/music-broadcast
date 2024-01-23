package com.music.distribution.batch;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
@Component
public class MusicBatchReader implements ItemReader<SyndEntry> {

    private final Iterator<SyndEntry> channelIterator;
    private static final Logger log = LoggerFactory.getLogger(MusicBatchReader.class);
    String rssFeedUrl = "https://www.francetvinfo.fr/culture/musique.rss";
    public MusicBatchReader() throws IOException, FeedException {
        SyndFeedInput syndFeedInput = new SyndFeedInput();
        syndFeedInput.setXmlHealerOn(true);

        URL url = new URL(this.rssFeedUrl);

        SyndFeed syndFeed = syndFeedInput.build(new XmlReader(url));

        this.channelIterator = syndFeed.getEntries().iterator();
    }

    @Override
    public SyndEntry read() {
        return channelIterator.hasNext() ? channelIterator.next() : null;
    }

}