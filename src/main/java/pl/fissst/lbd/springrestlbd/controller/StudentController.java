package pl.fissst.lbd.springrestlbd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.springrestlbd.model.Student;
import pl.fissst.lbd.springrestlbd.model.uniqueSubject;
import pl.fissst.lbd.springrestlbd.services.StudentService;

import java.util.List;

    @RestController
    @RequestMapping(value = "/api/student")
    public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity <List<Student>> getAllStudents() {
        return ResponseEntity.ok()
                .header("successful","true")
                .body(studentService.getAllStudents());}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        return ResponseEntity.ok()
                .header("successful","true")
                .body(studentService.getStudent(id));}

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PostMapping(value = "add")
        public void addStudent(@RequestBody Student student){
            studentService.addStudent(student);
        }

        @PutMapping(value = "/edit/{id}")
        public void editStudent(@PathVariable("id") int id, @RequestParam("newSurname") String newSurname, @RequestParam("newAge") int age){
        studentService.editStudent(id,newSurname,age);
        }

    }








