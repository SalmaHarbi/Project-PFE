package com.entreprise.msdepense.batchConfig;


import com.entreprise.msdepense.entities.Depense;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Slf4j
@Configuration
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final EntityManagerFactory entityManagerFactory;


    @Autowired
    private DataSource dataSource;

    public BatchConfig(JobRepository jobRepository,
                       PlatformTransactionManager transactionManager,
                       EntityManagerFactory entityManagerFactory) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    public Job simpleJob(Step step) {
        return new JobBuilder("RecalculMontant", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JpaPagingItemReader<Depense> reader,
                     ItemProcessor<Depense, Depense> processor,
                     ItemWriter<Depense> writer) {
        return new StepBuilder("RecalculMontant", jobRepository)
                .<Depense, Depense>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }


    @Bean
    public JpaPagingItemReader<Depense> reader(EntityManagerFactory entityManagerFactory) {
        JpaPagingItemReader<Depense> reader = new JpaPagingItemReader<>();
        reader.setName("RecalculMontant");
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT d FROM Depense d WHERE d.device = 'MAD'");
        reader.setPageSize(10);
        reader.setSaveState(true);
        return reader;
    }


    @Bean
    public ItemProcessor<Depense, Depense> processor() {
        return depense -> {
            if ("MAD".equals(depense.getDevice())
                    && depense.getTauxchange() != null
                    && depense.getMontant() != null
                    && depense.getMontantconverti() == null) {

                BigDecimal montant = depense.getMontant();         // pas de valueOf
                BigDecimal taux = depense.getTauxchange();
                BigDecimal montantConverti = montant.multiply(taux);

                depense.setMontantconverti(montantConverti); // maintenant on passe un BigDecimal
            }
            return depense;
        };
    }


    @Bean
    public ItemWriter<Depense> writer() {
        return new DatabaseItemWriter();
    }
}