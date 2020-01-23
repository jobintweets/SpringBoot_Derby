package com.springpractice.myspringapp;

import com.springpractice.myspringapp.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
  public List<Topic> findByDescription(String description);
//  CrudRepository<Topic,Integer> Topic is the class that i'm working on and Integer is the data type of the primary key id'
}
