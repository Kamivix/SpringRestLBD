package pl.fissst.lbd.springrestlbd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.springrestlbd.model.Student;
import pl.fissst.lbd.springrestlbd.model.Teacher;
import pl.fissst.lbd.springrestlbd.model.uniqueSubject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pl.fissst.lbd.springrestlbd.model.uniqueSubject.*;
@Service
public class TeacherService {
StudentService studentService;
@Autowired
    public TeacherService(StudentService studentService) {
        this.studentService = studentService;
    }

    List<Teacher> teacherList = new ArrayList<>(Arrays.asList(
            new Teacher(1, "Marzena", "Fals",BIOLOGY),
            new Teacher(2, "Andrzej", "Grechuta",LAW),
            new Teacher(3, "Robert", "Burnejka", ALGEBRA)
    ));


    public void addTeacher(Teacher teacher){
        teacherList.add(new Teacher(teacherList.get(teacherList.size()-1).getId()+1, teacher.getName(), teacher.getSurname(), teacher.getSubject()));
    }

    public void deleteTeacher(int id){
        teacherList.remove(id);
    }

    public Teacher getTeacher(int id){
        System.out.println(teacherList);
        return teacherList.get(id-1);

    }

    public List<Student> getTeacherClass(int id){
       return studentService.studentList.
               stream().
               filter(student -> student.getList().contains(teacherList.get(id-1).getSubject())).
               collect(Collectors.toList());
    }


    public void deleteStudentFromClassByTeacherId(int teacherId,int studentId){

        if(studentService.studentList.get(studentId-1).getList().contains(teacherList.get(teacherId-1).getSubject())) {
            studentService.studentList.get(studentId-1).getList().remove(teacherList.get(teacherId-1).getSubject());
        }
        else{
            System.out.println("Blad");
        }
    }


}

