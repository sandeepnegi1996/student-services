package com.hashcodehub.springboot.studentservices.Controller;


import com.hashcodehub.springboot.studentservices.Model.Course;
import com.hashcodehub.springboot.studentservices.StudentServicesApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentServicesApplication.class,webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

    @LocalServerPort
    private int port;


    TestRestTemplate restTemplate=new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudent1Course1() throws JSONException {

        HttpEntity<String> entity=new HttpEntity<>(null,headers);

       ResponseEntity<String> response =  restTemplate.exchange(
                createURLWithPort("/students/Student1/courses/Course1"),
                HttpMethod.GET,entity,String.class);

       String expected="{\"name\":\"spring\",\"id\":\"Course1\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
        JSONAssert.assertEquals(expected,response.getBody(),false);

    }

    @Test
    public void testRetrieveStudent2Course2() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        ResponseEntity<String> response= restTemplate.exchange(
                createURLWithPort("/students/Student2/courses/Course2"),
                HttpMethod.GET,entity,String.class
        );

        String expected="{\"name\":\"spring MVC\",\"id\":\"Course2\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

        JSONAssert.assertEquals(expected,response.getBody(),false);

    }
    


    @Test
    public void addCourse() {

        List<String> stepsList= Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example");

        Course course = new Course("Course5","Science","10Steps",
               stepsList );


        // with this httpEntity we can pass the required headers and body whatever we wanted to pass
        HttpEntity<Course> entity = new HttpEntity<>(course,headers);

        ResponseEntity<String> response=restTemplate.exchange(
                createURLWithPort("/students/Student1/courses"),
                HttpMethod.POST,entity,String.class);

        String actual= response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/students/Student1/courses/"));

    }






    private String createURLWithPort(String uri) {
        return "http://localhost:"+port+uri;
    }




}
