package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class MusicBatchStep {
    public final String name = "stepImport";
    @Autowired
    JobRepository jobRepository;
    @Autowired
    @Qualifier("MusicBatchRepository")
    PlatformTransactionManager transactionManager;
    @Autowired
    MusicBatchProcessing processor;
    @Autowired
    MusicBatchWriter writer;
    @Autowired
    MusicBatchReader reader;
    @Bean(name = "MusicBatchStepImport")
    protected Step stepImport() {
        return new StepBuilder(this.name, jobRepository)
                .<SyndEntry, Music> chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
