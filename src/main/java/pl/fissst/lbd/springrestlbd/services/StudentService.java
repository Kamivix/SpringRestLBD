package pl.fissst.lbd.springrestlbd.services;

import org.springframework.stereotype.Service;
import pl.fissst.lbd.springrestlbd.model.Student;
import pl.fissst.lbd.springrestlbd.model.uniqueSubject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pl.fissst.lbd.springrestlbd.model.uniqueSubject.*;

@Service
public class StudentService {


    List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1, "Kamil", "Partyka", 24,new ArrayList<>(Arrays.asList(ALGEBRA, LAW, BIOLOGY))),
            new Student(2, "Bartosz", "Piguła", 24,new ArrayList<>(Arrays.asList(BIOLOGY))),
            new Student(3, "Szymon", "Zawadzki", 24,new ArrayList<>(Arrays.asList(ALGEBRA,BIOLOGY))),
            new Student(4, "Nina", "Zając", 22,new ArrayList<>(Arrays.asList(ALGEBRA, LAW))),
            new Student(5, "Michał", "Lysko", 24,new ArrayList<>(Arrays.asList(LAW, BIOLOGY))),
            new Student(6, "Przemysław", "Piórko", 24,new ArrayList<>(Arrays.asList(ALGEBRA, LAW, BIOLOGY))),
            new Student(7, "Michał", "Żurawka", 24,new ArrayList<>(Arrays.asList(BIOLOGY))),
            new Student(8, "Sebastian", "Nowak", 23,new ArrayList<>(Arrays.asList(ALGEBRA,BIOLOGY))),
            new Student(9, "Marcin", "Bochenek", 19,new ArrayList<>(Arrays.asList(ALGEBRA, LAW))),
            new Student(10, "Julia", "Palichleb", 22,new ArrayList<>(Arrays.asList(LAW, BIOLOGY)))


    ));



    public List<Student> getAllStudents(){
    return  studentList;
    }

    public void deleteStudent(int id){
        studentList.remove(id-1);

    }

    public void editStudent(int id,String newSurname,int newAge){
        Student student=getStudent(id);
        student.setSurname(newSurname);
        student.setAge(newAge);

    }

   public void addStudent(Student student){
        studentList.add(new Student(studentList.get(studentList.size()-1).getId()+1, student.getName(),student.getSurname(),student.getAge(),student.getList()));
    }

    public Student getStudent(int id){

        return studentList.get(id-1);
    }
}
