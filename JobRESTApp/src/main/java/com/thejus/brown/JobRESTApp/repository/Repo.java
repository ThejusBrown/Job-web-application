package com.thejus.brown.JobRESTApp.repository;


import com.thejus.brown.JobRESTApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public interface Repo extends JpaRepository<JobPost,Integer> {


        List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String PostDesc);
}
