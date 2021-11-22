package com.tutorial.xyz.controller.mgmt;

import java.util.List;

import com.tutorial.xyz.dto.Admin;
import com.tutorial.xyz.mapper.AdminMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mgmt")
public class AdminController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private AdminMapper mapper;

  public AdminController(AdminMapper mapper) {
    this.mapper = mapper;
  }

  // 관리자 목록
  @GetMapping("/admin")
  public String list(Model model) {
    List<Admin> admins = mapper.listAdmin();
    model.addAttribute("admins", admins);

    return "mgmt/admin/list";
  }

  // 관리자 추가 폼
  @GetMapping("/admin/insert_form")
  public String insertForm() {
    return "mgmt/admin/insert_form";
  }

  // 관리자 추가
  @PostMapping("/admin/insert")
  public String insert(@RequestParam("userid") String userid, @RequestParam("passwd1") String passwd1, @RequestParam("passwd2") String passwd2, @RequestParam("nick") String nick) {
    String password;
    if(!passwd1.equals(passwd2)) {
      return "redirect:/mgmt/admin";
    }
    password = passwd1;
    mapper.insertAdmin(userid, password, nick);
    // logger.info("관리자 추가 성공");
    return "redirect:/mgmt/admin";
  }

  // 관리자 비밀번호 변경 폼
  @GetMapping("/admin/chg_passwd_form/{id}")
  public String chePasswdForm(@PathVariable("id") Long id, Model model) {
    // logger.info("1111111111");
    Admin admin = mapper.getAdmin(id);
    model.addAttribute("admin", admin);
    return "mgmt/admin/chg_passwd_form";
  }

  // 관리자 비밀번호 수정
  @PostMapping("/admin/chg_passwd")
  public String chg_passwd(@RequestParam("id") Long id, @RequestParam("passwd1") String passwd1, @RequestParam("passwd2") String passwd2) {
    if(!passwd1.equals(passwd2)) {
      return "redirect:/mgmt/admin";
    }
    mapper.updateAdminPassword(id, passwd1);
    return "redirect:/mgmt/admin";
  }
}
