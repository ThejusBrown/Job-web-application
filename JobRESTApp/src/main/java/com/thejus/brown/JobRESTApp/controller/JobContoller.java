package com.thejus.brown.JobRESTApp.controller;

import com.thejus.brown.JobRESTApp.model.JobPost;
import com.thejus.brown.JobRESTApp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobContoller {
    @Autowired
    private Service service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJob();
    }
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> getJob(@PathVariable("keyword") String keyword){
       return service.search(keyword);

    }    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addjob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob((jobPost.getPostId()));
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return"Deleted";
    }
    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }
}
