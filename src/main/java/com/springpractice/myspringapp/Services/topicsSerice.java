package com.springpractice.myspringapp.Services;

import com.springpractice.myspringapp.TopicRepository;
import com.springpractice.myspringapp.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class topicsSerice {


  @Autowired
  private TopicRepository tR;
  public topicsSerice(TopicRepository tR) {
    this.tR = tR;
  }

//  private  List<Topic> topics= new ArrayList<>(Arrays.asList(
//    new Topic(1,"Kotlin","Comprehensive Kotlin"),
//    new Topic(2,"Golang","Head first golang"),
//    new Topic(3,"JS","Full stack js")
//  ));
//  Arrays.asList is immutable
  public List<Topic> getTopics() {
    List<Topic> topics1=new ArrayList<>();
//    return  topics;
    tR.findAll().forEach(topics1::add);
    return topics1;
  }
  public void addTopic(Topic topic ) {
    tR.save(topic);

//   topics.add(topic);
  }

  public List<Topic> test(String str) {
     return tR.findByDescription(str);

  }
   public Optional<Topic> getSingleTopic(int id){

//   return topics.stream().filter(topic->topic.getId()==id).findFirst();
     return tR.findById(id);
  }


  public String deleteTopic(int id) {
//Optional<Topic> topicPresent= getSingleTopic(id);
//if(topicPresent.isPresent()){
//  topics.remove(topicPresent.get());
//  return "Successfully deleted";
//}
//else{
//return "The topic is not found ";
//}
    tR.deleteById(id);
    return "deleted";
  }

  public Optional<Topic> updateTopic(int id, Topic topic) {
//    for (Topic iterator:topics) {
//    if(iterator.getId()==id){
//      int index=topics.indexOf(iterator);
//      topics.set(index,topic);
//    return getSingleTopic(id);
//    }
//    }
    tR.save(topic);
    return getSingleTopic(id);
  }
}
