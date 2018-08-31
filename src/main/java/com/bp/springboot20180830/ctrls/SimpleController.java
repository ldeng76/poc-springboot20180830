package com.bp.springboot20180830.ctrls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by dzy on 2018/8/30
 */
@Controller
public class SimpleController {
  @Value("${spring.application.name}")
  String appName ;

  @GetMapping("/")
  public String homePage(Model model){
    model.addAttribute("appName",appName);
    return "home";
  }

}
