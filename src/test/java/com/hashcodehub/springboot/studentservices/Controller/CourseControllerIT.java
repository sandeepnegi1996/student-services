package com.hashcodehub.springboot.studentservices.Controller;

import com.hashcodehub.springboot.studentservices.StudentServicesApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentServicesApplication.class,webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-stage.yml")
public class CourseControllerIT {

    @LocalServerPort
    private int port;

    @Value("${database.url}")
    private String databaseurl;


    TestRestTemplate restTemplate=new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudent1Course1() throws JSONException {

        System.out.println(databaseurl);

        HttpEntity<String> entity=new HttpEntity<>(null,headers);

        ResponseEntity<String> response =  restTemplate.exchange(
                createURLWithPort("/students/Student1/courses/Course1"),
                HttpMethod.GET,entity,String.class);

        String expected="{\"name\":\"spring\",\"id\":\"Course1\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
        JSONAssert.assertEquals(expected,response.getBody(),false);

        System.out.println(response.getStatusCode());

//        log.info(response.getBody());
        System.out.println(response.getBody());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:"+port+uri;
    }


}
