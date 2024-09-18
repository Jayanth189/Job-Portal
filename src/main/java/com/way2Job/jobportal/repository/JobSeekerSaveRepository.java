package com.way2Job.jobportal.repository;

import com.way2Job.jobportal.entity.JobPostActivity;
import com.way2Job.jobportal.entity.JobSeekerProfile;
import com.way2Job.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);
}
