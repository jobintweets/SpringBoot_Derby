package com.springpractice.myspringapp.Controller;

import com.springpractice.myspringapp.Services.topicsSerice;
import com.springpractice.myspringapp.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")

public class TopicsController {

  @Autowired
  private  final topicsSerice tService;

  public TopicsController(topicsSerice tService) {
    this.tService = tService;
  }


  @GetMapping
  public List<Topic> getAllTopics () {
    return tService.getTopics();
  }

//  @GetMapping(path =  "{id}")
//   public Optional<Topic> getTopic(@PathVariable("id") int id) {
//    return tService.getSingleTopic(id);
//
//  }
  @PostMapping
  public List<Topic> addTopic( @Valid @NotNull @RequestBody  Topic topic ){
     tService.addTopic(topic);
     return tService.getTopics();
  }
  @DeleteMapping(path = "{id}")
   public String  delete(@PathVariable("id") int id ) {
  return  tService.deleteTopic(id);
  }

  @PutMapping(path="{id}")
  public Optional<Topic> update(@PathVariable("id") int id, @RequestBody Topic topic) {
    return  tService.updateTopic(id,topic);
  }

  @GetMapping (path="{description}")
  public List<Topic> somefunction(@PathVariable("description") String description){
    return tService.test(description);

  }
}
