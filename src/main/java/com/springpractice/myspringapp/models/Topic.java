package com.springpractice.myspringapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Topic {
  public Topic() {
  }

  @Id
  // making id as the primary key.
  private int id;
  private String name;
  private  String description;

  public Topic(@JsonProperty("id") int id,
               @JsonProperty("name") String name,
               @JsonProperty("description") String description) {
    this.id = id;
    this.name = name;
    this.description = description;
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
}
