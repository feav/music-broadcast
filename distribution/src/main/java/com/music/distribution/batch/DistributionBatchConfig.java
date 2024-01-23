package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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
    private MusicBatchJob musicBatchJob;
    @Bean
    public ItemReader<SyndEntry> rssReader() throws FeedException, IOException {
        return new MusicBatchReader();
    }
    @Bean
    public ItemProcessor<SyndEntry, Music> rssProcessor() {
        return new MusicBatchProcessing();
    }
    @Bean
    public ItemWriter<Music> rssWriter() {
        return new MusicBatchWriter();
    }
    @Bean(name = "ImportMusicJob")
    public Job rssJob() {
        return this.musicBatchJob.stepImport();
    }
}
