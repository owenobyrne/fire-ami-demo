package com.fire.ami.repositories;

import com.fire.ami.models.Job;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class JobsRepository {
    public List<Job> getJobs() {
        return Arrays.asList(
                new Job().setName("Test Job")
        );
    }

    public List<Job> getJobsWithFilter(String filter) {
        return Arrays.asList(
                new Job().setName("Test Job")
        );
    }

    public void save(Job job) {
        // todo
    }

    public void delete(Job job) {
        // todo
    }
}
