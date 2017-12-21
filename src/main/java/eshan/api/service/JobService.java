package eshan.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import eshan.api.domain.JobSearch;

@Service
public class JobService {
	
	private List<JobSearch> jobsearch =  new ArrayList<JobSearch>(Arrays.asList(
			new JobSearch("1","Java Develper","Job Applied with Coespan"),
			new JobSearch("2","Java Develper","Job Applied with Braindigit"),
			new JobSearch("3","Java Develper","Job Applied with Maharishi")
		
		));
	
	
	public List<JobSearch> getAllJob(){
		return jobsearch;
	}

	public JobSearch getJob(String id) {
		return jobsearch.stream()
		.filter(t->t.getId().equals(id)).findFirst().get();
		
	}

	public void addJob(JobSearch job) {
		jobsearch.add(job);
		
	}

	public void updateJob(JobSearch job, String id) {
	  for(int i=0;i<jobsearch.size();i++) {
		    if(jobsearch.get(i).getId().equals(id)) {
		    	jobsearch.set(i, job);
		    	return;
		    }
	  }
	}

	public void deleteJob(String id) {
		for(int i=0;i<jobsearch.size();i++) {
			if(jobsearch.get(i).getId().equals(id)) {
				jobsearch.remove(i);
			}
		}
		
	}
	


}
