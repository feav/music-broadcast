package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class DistributionBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<SyndEntry> rssReader() throws FeedException, IOException {
        return new MusicBatchReader("https://www.francetvinfo.fr/culture/musique.rss");
    }

    @Bean
    public ItemProcessor<SyndEntry, Music> rssProcessor() {
        return new MusicBatchProcessing();
    }

    @Bean
    public ItemWriter<Music> rssWriter() {
        return new MusicBatchWriter();
    }

    @Bean
    public Step rssStep(ItemReader<SyndEntry> reader, ItemProcessor<SyndEntry, YourDataObject> processor,
                        ItemWriter<YourDataObject> writer) {
        return stepBuilderFactory.get("rssStep")
                .<SyndEntry, YourDataObject>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job rssJob(Step rssStep) {
        return jobBuilderFactory.get("rssJob")
                .incrementer(new RunIdIncrementer())
                .flow(rssStep)
                .end()
                .build();
    }
}
