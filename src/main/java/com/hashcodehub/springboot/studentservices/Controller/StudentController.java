package com.hashcodehub.springboot.studentservices.Controller;

import com.hashcodehub.springboot.studentservices.Model.Course;
import com.hashcodehub.springboot.studentservices.Model.Student;
import com.hashcodehub.springboot.studentservices.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/courses")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping()
    public List<Course> retreiveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retreiveCourses(studentId);
    }

    @GetMapping("/{courseId}")
    public Course retreiveDetailsForCourse(@PathVariable String studentId,@PathVariable String courseId ) {
        return studentService.retreiveCourse(studentId,courseId);
    }


    @PostMapping()
    public ResponseEntity<Void> registerStudentForCourse(@PathVariable String studentId, @RequestBody Course newCourse) {

        Course course=studentService.addCourse(studentId,newCourse);

        if(course==null) {
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



}
