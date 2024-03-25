package com.hashcodehub.springboot.studentservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashcodehub.springboot.studentservices.Model.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(StudentServicesApplication.class, args);

//
//		Dog d1 = new Dog("tommy");
//		ObjectMapper mapper = new ObjectMapper();
//
//		//writing Dog Object as String
//		String d1JsonString = mapper.writeValueAsString(d1);
//
//
//		System.out.println(d1JsonString);
//
//
//		//deserialize it
//		// make sure the model class contains the Default Contrustor otherwise there will be error
//		Dog d2= mapper.readValue(d1JsonString,Dog.class);
//
//		System.out.println(d2);
//
//
//		slash is added before the double quotes
//		String jsonStringModifiedPropertyName = "{\"dogName\":\"tommy\"}";
//		Dog d3= mapper.readValue(jsonStringModifiedPropertyName,Dog.class);
//		System.out.println(d3);
//
//
//		now deserialize if hte json string property name is different from the pojo classes
//		here the property name as smae as the @JsonProperty Name is the class Dog
//		String jsonStringModifiedPropertyName2 = "{\"Doggy_Name\":\"tommy\"}";
//		Dog d4= mapper.readValue(jsonStringModifiedPropertyName2,Dog.class);
//		System.out.println(d4);


		// converting the jsonString Array of objects into a list

//		Dog d5 = new Dog("tommy");
//		Dog d6 = new Dog("sheru");
//
//		List<Dog> listOfDogObject = Arrays.asList(d5,d6);
//		ObjectMapper mapper5 = new ObjectMapper();
//
//		//writing Dog Object as String
//		String listOfDogString = mapper5.writeValueAsString(listOfDogObject);
//		System.out.println(listOfDogString);
//
//
//		List<Dog> listOfDog= mapper5.readValue(listOfDogString, new TypeReference<List<Dog>>() {
//		});
//
//		System.out.println(listOfDogString);

		// we can also convert json string to a hashNap
//		since hashmap is a key-value pair and json String is also keyvalue Pair and hence we can easily convert
//		json String to hashmap

		//
		Dog d1 = new Dog("tommy");
		ObjectMapper mapper = new ObjectMapper();

		//writing Dog Object as String
		String d1JsonString = mapper.writeValueAsString(d1);
		
//		HashMap map= mapper.readValue(d1JsonString, new TypeReference<HashMap>() {
//		});
//
//
//		System.out.println(map);


		//jackson tree model if we are not aware of the type of model or json we are going to receive in that case we can use this generic model
		//converting a json string to JsonNode
		System.out.println(d1JsonString);
//		JsonNode DogNode= mapper.valueToTree(d1JsonString);
		JsonNode DogNode3=  mapper.readTree(d1JsonString);

//		System.out.println(DogNode.get("dogName"));
		System.out.println(DogNode3.isEmpty());
		System.out.println(DogNode3.get("Doggy_Name"));


//		Dog t1= mapper.treeToValue(DogNode,Dog.class);
//
//		System.out.println(t1);















	}

}
