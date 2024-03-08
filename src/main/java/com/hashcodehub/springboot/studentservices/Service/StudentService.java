package com.hashcodehub.springboot.studentservices.Service;

import com.hashcodehub.springboot.studentservices.Model.Course;
import com.hashcodehub.springboot.studentservices.Model.Student;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    //creating static data just to store and work with it

    private static final List<Student> students=new ArrayList<>();
    private final SecureRandom random = new SecureRandom();

    static {
        //Initialize Data

        Course courseOne=new Course("Course1","spring","10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseTwo=new Course("Course2","spring MVC","10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));


        Course courseThree=new Course("Course3","spring Boot","10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));


        Course courseFour=new Course("Course4","Maven","10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));


        List<Course> courses= new ArrayList<>();
        courses.add(courseOne);
        courses.add(courseTwo);
        courses.add(courseThree);
        courses.add(courseFour);

        Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
               courses);


        Student satish = new Student("Student2", "Satish", "Hiker, Programmer",
                courses);



        students.add(ranga);
        students.add(satish);




    }


//    public List<Course> retrieveCourses(String studentId) {
//        return
//    }

    public List<Student> retreiveAllStudents() {
        return students;
    }

    //retreive  a particular student from the list

    public Student retreiveStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findAny()
                .orElse(null);
    }

    //retreive all the courses for a student

    public List<Course> retreiveCourses(String studentId) {
        Student student= retreiveStudent(studentId);
      return  student==null ?null : student.getCourses();

    }

    //retrieve a particular couse of a particlar student

    public Course retreiveCourse(String studentId,String courseId) {
        Student student = retreiveStudent(studentId);

        List<Course> courses= student.getCourses();

        return courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findAny()
                .orElse(null);


    }

    public Course addCourse(String studentId, Course course) {
        Student student = retreiveStudent(studentId);

        if (student == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);

        student.getCourses()
                .add(course);

        return course;
    }





}
