package eshan.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eshan.api.domain.JobSearch;
import eshan.api.service.JobService;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@Autowired
	private JobService jobservice;
	
	@RequestMapping("/getalljob")
	@CrossOrigin(origins="http://localhost:4200")
	public List<JobSearch> getAllJob() {
		return jobservice.getAllJob();
		
	}
	
	@RequestMapping("/jobsearch/{id}")
	public JobSearch getJob(@PathVariable String id) {
		return jobservice.getJob(id);
	}
	
	@RequestMapping(value="/getalljob", method=RequestMethod.POST)
	public void addJob(@RequestBody JobSearch job) {
		jobservice.addJob(job);
		
	}
	
	@RequestMapping(value="/jobsearch/{id}", method=RequestMethod.PUT)
	public void updateJob(@RequestBody JobSearch job,@PathVariable String id) {
		jobservice.updateJob(job,id);
	}
	

	@RequestMapping(value="/jobsearch/{id}", method=RequestMethod.DELETE)
	public void deleteJob(@PathVariable String id) {
		jobservice.deleteJob(id);
	}
}
