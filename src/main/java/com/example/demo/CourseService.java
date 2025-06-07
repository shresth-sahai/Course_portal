package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCOurses(){
        return courseRepository.findAll();
    }
    public void save(Course course){
        courseRepository.save(course);
    }
}
