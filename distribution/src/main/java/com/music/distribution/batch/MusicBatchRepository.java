package com.music.distribution.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Component
public class MusicBatchRepository {

        @Autowired
        DataSource dataSource; // possibilité de changer de source de persistance de données
        @Autowired
        PlatformTransactionManager platformTransactionManager;
        @Bean(name = "MusicBatchRepository")
        protected JobRepository stepImport() throws Exception {
            JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
            factory.setDataSource(dataSource);
            factory.setTransactionManager(platformTransactionManager);
            factory.afterPropertiesSet();
            return factory.getObject();
        }
}
