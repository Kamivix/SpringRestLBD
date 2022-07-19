package pl.fissst.lbd.springrestlbd.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String surname;
    private int age;

    public Student(int id, String name, String surname, int age,List<uniqueSubject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        list.addAll(subjects);
    }

    private List<uniqueSubject> list = new ArrayList<>();

}
