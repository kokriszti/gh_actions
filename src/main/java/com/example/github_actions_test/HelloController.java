package com.example.github_actions_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {

//  if no endpoint on "/" path, index.html is served as default
//  @GetMapping("/")
//  @ResponseBody
//  public String hello() {
//    return "hello";
//  }

//  serve index.html on an endpoint
  @GetMapping("/car")
  public String car() {
    return "index.html";
  }

  @GetMapping("/public")
  @ResponseBody
  public String publicResource() {
    return "This endpoint is available for everyone.";
  }

  @GetMapping("/protected")
  @ResponseBody
  public String protectedResource() {
    return "This endpoint is protected.";
  }

//  if @RestController instead of @Controller

//  @GetMapping("/")
//  public String hello() {
//    return "hello";
//  }

//  @GetMapping("/public")
//  public String publicResource() {
//    return "This endpoint is available for everyone";
//  }
//
//  @GetMapping("/protected")
//  public String protectedResource() {
//    return "This endpoint is protected";
//  }

}

