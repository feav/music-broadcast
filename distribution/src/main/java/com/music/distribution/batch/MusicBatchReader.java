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
import java.util.Iterator;
@Component
public class MusicBatchReader implements ItemReader<SyndEntry> {

    private final String rssFeedUrl;
    private final Iterator<SyndEntry> channelIterator;
    private static final Logger log = LoggerFactory.getLogger(MusicBatchReader.class);
    public MusicBatchReader(String rssFeedUrl) throws IOException, FeedException {
        this.rssFeedUrl = rssFeedUrl;
        SyndFeedInput syndFeedInput = new SyndFeedInput();
        syndFeedInput.setXmlHealerOn(true);
        File outputFile = new File(this.rssFeedUrl);

        SyndFeed syndFeed = syndFeedInput.build(new XmlReader(outputFile));

        this.channelIterator = syndFeed.getEntries().iterator();
    }

    @Override
    public SyndEntry read() {
        return channelIterator.hasNext() ? channelIterator.next() : null;
    }

}