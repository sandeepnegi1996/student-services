package com.hashcodehub.springboot.studentservices.Controller;


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
//
//When we are writing an integration test for a rest service, we would want to launch the entire spring context.
//
//@SpringBootTest(classes = StudentServicesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) : Launch the entire Spring Boot Application on a Random Port
//@LocalServerPort private int port;: Autowire the random port into the variable so that we can use it create the url.
//        createURLWithPort(String uri) : Utility method to create the url given an uri. It appends the port.
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);: We use entity so that we have the flexibility of adding in request headers in future.
//        restTemplate.exchange(createURLWithPort("/students/Student1/courses/Course1"),HttpMethod.GET, entity, String.class): Fire a GET request to the specify uri and get the response as a String.
//        JSONAssert.assertEquals(expected, response.getBody(), false) : Assert that the response contains expected fields.

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



    private String createURLWithPort(String uri) {
        return "http://localhost:"+port+uri;
    }




}
