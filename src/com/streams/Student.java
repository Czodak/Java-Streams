package com.streams;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private List<String> skills;

    public Student(String firstName, String lastName, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
    }


    public int getSkillsListSize(){
        return this.skills.size();
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                '}';
    }
}
