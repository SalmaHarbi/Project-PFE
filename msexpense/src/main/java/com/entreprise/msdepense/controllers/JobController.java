package com.entreprise.msdepense.controllers;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public JobController(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("/run-job")
    public String runJob() {
        try {
            JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
            return "Job exécuté avec statut : " + jobExecution.getStatus();
        } catch (Exception e) {
            e.printStackTrace();
            return "Échec de l'exécution du job : " + e.getMessage();
        }
    }
}
