package pl.fissst.lbd.springrestlbd;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.fissst.lbd.springrestlbd.model.Student;
import pl.fissst.lbd.springrestlbd.model.Teacher;
import pl.fissst.lbd.springrestlbd.model.uniqueSubject;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.fissst.lbd.springrestlbd.model.uniqueSubject.ALGEBRA;

@SpringBootTest
@AutoConfigureMockMvc

class SpringRestLbdApplicationTests {
@Autowired
   private MockMvc mockMvc;



   @Test void getStudentAll() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/api/student"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$.[0].name", Is.is("Kamil")));
   }

   @Test void getStudent() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/api/student/1"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.name", Is.is("Kamil")));
   }

   @Test
   void addStudent() throws Exception{
      ObjectMapper objectMapper = new ObjectMapper();
      mockMvc.perform(MockMvcRequestBuilders.post("/api/student/add")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(new Student(69,"test", "test2", 43,new ArrayList<>(Arrays.asList(ALGEBRA))))))
              .andDo(print())
              .andExpect(status().isOk());
   }

   @Test

   void editStudent() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.put("/api/student/edit/1")
              .param("newSurname", "Nowy")
              .param("newAge","100")).andDo(print()).andExpect(status().isOk());

      mockMvc.perform(MockMvcRequestBuilders.get("/api/student"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$.[0].surname", Is.is("Nowy")));


   }

   @Test
   void deleteStudent() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/delete/1")).andExpect(status().isOk());

      mockMvc.perform(MockMvcRequestBuilders.get("/api/student"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$.[0].name", Is.is("Bartosz")));
   }

   @Test
   void addTeacher() throws Exception{
      ObjectMapper objectMapper = new ObjectMapper();
      mockMvc.perform(MockMvcRequestBuilders.post("/api/teacher/adding")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(new Teacher(69,"test","test2", ALGEBRA))))
              .andDo(print())
              .andExpect(status().isOk());

   }

   @Test

   void deleteTeacher() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/delete/1")).andExpect(status().isOk());

      mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/find/1"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.name", Is.is("Andrzej")));
   }

   @Test

   void findTeacher() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/find/1"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.name",Is.is("Marzena")));
   }


   @Test
   void findClassBySubject() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/teacherclass/1"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$.[0].name", Is.is("Kamil")));
   }
   @Test

   void deletePeopleFromTeacherClass() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/deleting")
              .param("teacherId","1")
              .param("studentId","1"))
              .andExpect(status().isOk());

      mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/teacherclass/1"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$").isArray())
              .andExpect(jsonPath("$.[0].name", Is.is("Bartosz")));
   }





}



