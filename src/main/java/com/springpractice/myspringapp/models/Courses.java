package com.springpractice.myspringapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Courses {
  public Courses() {
  }

  @Id
  // making id as the primary key.
  private int id;
  private String name;
  private  String description;
  @ManyToOne
  private Topic topic;
  //setting up the foreign key to the primary key id in topics.
  // linking topic to a course.every topic will have a course associated with it.
  //courses are tied to the topic.

  public Courses(@JsonProperty("id") int id,
               @JsonProperty("name") String name,
               @JsonProperty("description") String description,
  int topicId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.topic=new Topic(topicId,"","");
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  public void setTopic(Topic topic) {
    this.topic = topic;
  }
  public Topic getTopic() {
    return topic;
  }


}
