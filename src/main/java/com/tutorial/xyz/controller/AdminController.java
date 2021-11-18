package com.tutorial.xyz.controller;

import java.util.List;

import com.tutorial.xyz.mapper.AdminMapper;
import com.tutorial.xyz.model.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  private AdminMapper mapper;

  public AdminController(AdminMapper mapper) {
    this.mapper = mapper;
  }

  @GetMapping("/mgmt/admin")
  public String listAdmin(Model model) {
    List<Admin> admins = null;
    admins = mapper.listAdmin();
    model.addAttribute("admins", admins);
    model.addAttribute("userid", "admin");
    model.addAttribute("nick", "메인관리자");

    return "admin/list_admin";
  }

}
