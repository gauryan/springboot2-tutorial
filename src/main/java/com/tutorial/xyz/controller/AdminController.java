package com.tutorial.xyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
  @GetMapping("/mgmt/admin")
  public void listAdmin() {

  }
}
