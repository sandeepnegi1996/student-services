package com.hashcodehub.springboot.studentservices.Model;

import java.util.List;
import java.util.Objects;

public class Course {

    List<String> steps;
    private String name;
    private String id;
    private String description;

    public Course(String id, String name, String description, List<String> steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id ' " + id + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", steps=" + steps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals((course.id)) && name.equals(course.name) && description.equals(course.description) && steps.equals(course.steps);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, steps);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

}
