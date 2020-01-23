package com.springpractice.myspringapp.Services;

import com.springpractice.myspringapp.coursesRepository;
import com.springpractice.myspringapp.models.Courses;
import com.springpractice.myspringapp.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class coursesService {
  @Autowired
  private coursesRepository cR;

  public coursesService(coursesRepository cR) {
    this.cR = cR;
  }

  public List<Courses> getCourses() {
    List<Courses> courses = new ArrayList<>();
    cR.findAll().forEach(courses::add);
    return courses;
  }

  public void addCourse(Courses course) {
    cR.save(course);
  }

  public Optional<Courses> getSingleCourse(int id) {
    return cR.findById(id);
  }


  public String deleteCourse(int id) {
    cR.deleteById(id);
    return "deleted";
  }

  public Optional<Courses> updateCourse(int id,Courses course) {
    cR.save(course);
    return getSingleCourse(id);
  }
}
