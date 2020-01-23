package com.springpractice.myspringapp;

import com.springpractice.myspringapp.models.Courses;

import com.springpractice.myspringapp.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface coursesRepository extends CrudRepository<Courses, Integer> {

  public List<Courses> findByName(String name);
  public List<Courses> findByDescription(String description);
}
