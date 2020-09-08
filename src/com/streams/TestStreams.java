package com.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

    List<Student> studentList;

    @BeforeEach
    public void setUpDataForTest(){
        Student student1 = new Student("Lilly", " Iles", List.of("Java", "Cooking", "Dancing"));
        Student student2 = new Student("Rudy", "Foreman", List.of("Java", "Skating"));
        Student student3 = new Student("Nathanael", "Traynor", List.of("Python", "Java"));
        Student student4 = new Student("Raly", "Begum", List.of("Java", "Cooking"));
        Student student5 = new Student("Philip", "Rich", List.of("Python"));
        Student student6 = new Student("Mark", "House", List.of("Python", "Java", "Cpp", "C#", "SQL"));

        studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);


    }

    @Test
    public void mapOperation(){
        studentList.stream()
                .map(Student::getFirstName)
                .forEach(System.out::println);
    }

    @Test
    public void flatMap(){
        List<List<String>> allSkills = studentList.stream()
                .map(Student::getSkills)
                .collect(Collectors.toList());
        System.out.println(allSkills);

        List<String> allSkills2 = studentList.stream()
                .map(Student::getSkills)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allSkills2);
    }

    @Test
    public void filterOperation(){
        studentList.stream()
                .filter(student -> student.getFirstName().startsWith("R"))
                .forEach(System.out::println);
    }

    @Test
    public void sortOperation(){
        studentList.stream()
                .sorted(Comparator.comparing(student -> student.getSkills().size()))
                .forEach(System.out::println);
    }

    @Test
    public void limitOperation(){
        studentList.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation(){
        studentList.stream()
                .sorted(Comparator.comparing(Student::getSkillsListSize))
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation(){
        long count = studentList.stream()
                .filter(student -> student.getSkills().size() >= 2)
                .count();
        System.out.println(count);
    }

    @Test
    public void testMinMaxOperation(){
        Student student1 = studentList.stream()
                .max(Comparator.comparing(student -> student.getSkills().size()))
                .get();// min return Optional
        System.out.println(student1);
    }

    @Test
    public void findAnyFindFirstOperations(){
        Student r = studentList.stream()
                .filter(student -> student.getFirstName().startsWith("R"))
                .findAny().get();
        System.out.println(r);
    }

    @Test
    public void matchOperation(){
        boolean b = studentList.stream()
                .anyMatch(student -> student.getFirstName().startsWith("R"));
        System.out.println(b);
    }

    @Test
    public void reduceOperation(){
        // sum of all students skill list size
        Integer sumOfSkills = studentList.stream()
                .map(Student::getSkillsListSize)
                .reduce(Integer::sum)
                .get();
        System.out.println(sumOfSkills);

    }

    @Test
    public void reduceOperation2(){
        // String with all names separated by a comma
        String names = studentList.stream()
                .map(Student::getFirstName)
                .reduce((name,name2) -> name+", "+name2)
                .get();
        System.out.println(names);
    }

    @Test
    public void takeWhileOperation(){
        // print all student with amount of skills less than 3 using takeWhile
         studentList.stream()
            .sorted(Comparator.comparing(Student::getSkillsListSize))
            .takeWhile(student -> student.getSkillsListSize() < 3)
            .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation(){
        studentList.stream()
                .sorted(Comparator.comparing(Student::getSkillsListSize))
                .dropWhile(student -> student.getSkillsListSize()<3)
                .forEach(System.out::println);
    }



}
