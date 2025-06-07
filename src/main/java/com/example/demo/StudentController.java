package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private CourseService courseService;
    @Autowired private UserService userService;
    @GetMapping("/dashboard")
    public String studentDashBoard(Model model){
        model.addAttribute("courses",courseService.getAllCOurses());
        return "student-dashboard";
    }
    @PostMapping("/enroll")
    public String enroll(@RequestParam Long courseId, Authentication auth) {
        User user = userService.getByUsername(auth.getName());
        Course course = courseService.getAllCOurses().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst().orElse(null);
        if (course != null) {
            user.getCourses().add(course);
            userService.save(user);
        }
        return "redirect:/student/dashboard";
    }
}
