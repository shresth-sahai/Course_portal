package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
 @Autowired
 private CourseService courseService;
 @GetMapping("/dashboard")
    public String adminDashboard(Model model){
     model.addAttribute("courses",courseService.getAllCOurses());
     return "admin-dashboard";
 }
 @GetMapping("/add-course")
    public String addCourseForm(Model model){
     model.addAttribute("course",new Course());
     return "add-course";
 }
 @PostMapping("/add-course")
    public String addCourse(Course course){
     courseService.save(course);
     return "redirect:/admin/dashboard";
 }
}
