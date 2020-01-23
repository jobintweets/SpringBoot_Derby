package com.springpractice.myspringapp.Controller;

import com.springpractice.myspringapp.Services.coursesService;
import com.springpractice.myspringapp.Services.topicsSerice;
import com.springpractice.myspringapp.models.Courses;
import com.springpractice.myspringapp.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/courses")
public class coursesController {
  @Autowired
  private  final topicsSerice tService;
  private  final coursesService cService;

  public coursesController(topicsSerice tService, coursesService cService) {
    this.tService = tService;
    this.cService = cService;
  }


  @GetMapping
  public List<Courses> getAllTopics () {
    return cService.getCourses();
  }

  @GetMapping(path =  "{id}")
  public Optional<Courses> getTopic(@PathVariable("id") int id ) {
    return cService.getSingleCourse(id);
//return id+test;
  }
  @PostMapping(path="{topicID}")
  public List<Courses> addTopic(@PathVariable("topicID") int topicId,  @RequestBody Courses course ){
    course.setTopic(new Topic(topicId,"",""));
    cService.addCourse(course);
    return cService.getCourses();
  }
  @DeleteMapping(path = "{id}")
  public String  delete(@PathVariable("id") int id ) {
    return  cService.deleteCourse(id);
  }

//  @RequestMapping(method=RequestMethod.PUT,value="/specquestions/{subject}/{topic}")
  @PutMapping(path="{courseId}/{topicId}")
  public Optional<Courses> update(@PathVariable("courseId") int courseId,@PathVariable("topicId") int topicId, @RequestBody Courses  course) {
    course.setTopic(new Topic(topicId,"",""));
    return  cService.updateCourse(courseId,course);
  }
}
