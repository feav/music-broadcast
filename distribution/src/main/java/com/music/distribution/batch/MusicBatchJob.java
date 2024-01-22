package com.music.distribution.batch;

import com.music.distribution.entity.Music;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class MusicBatchJob {
    public final String name = "stepImport";
    @Autowired
    @Qualifier("MusicBatchRepository")
    JobRepository jobRepository;
    @Autowired
    @Qualifier("MusicBatchStepImport")
    Step musicBatchStepImport;
    @Bean(name = "MusicBatchJobImport")
    protected Job stepImport() {
        return new JobBuilder("importUserJob", jobRepository)
                .start(this.musicBatchStepImport)
                .build();
    }
}
