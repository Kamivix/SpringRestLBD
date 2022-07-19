package pl.fissst.lbd.springrestlbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fissst.lbd.springrestlbd.model.Student;
import pl.fissst.lbd.springrestlbd.model.Teacher;
import pl.fissst.lbd.springrestlbd.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id){
        return ResponseEntity.ok()
                .header("successful","true")
                .body(teacherService.getTeacher(id));}



    @GetMapping(value = "/teacherclass/{id}")
    public ResponseEntity<List<Student>> getTeacherClass(@PathVariable int id){
        return ResponseEntity.ok()
                .header("successful","true")
                .body(teacherService.getTeacherClass(id));
    }


    @DeleteMapping(value = "deleting")
    public void deleteStudentFromClassByTeacherId(@RequestParam("teacherId") int teacherId, @RequestParam("studentId") int studentId){
        teacherService.deleteStudentFromClassByTeacherId(teacherId,studentId);
    }

    @PostMapping(value = "adding")
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

}
