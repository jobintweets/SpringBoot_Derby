package com.springpractice.myspringapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
public class Hello {

  @GetMapping
  public String  displayHello() {
   return "Hello World";
  }

}
