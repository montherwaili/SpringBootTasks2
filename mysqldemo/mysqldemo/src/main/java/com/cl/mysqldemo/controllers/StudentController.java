package com.cl.mysqldemo.controllers;

import com.cl.mysqldemo.dto.StudentDTO;
import com.cl.mysqldemo.entities.Student;
import com.cl.mysqldemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // add new student
    @PostMapping("add")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    // GetBYId
    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id) {
        Student student = studentService.getById(id);
        return StudentDTO.convertToDTO(student);
    }

    // GetAll
    @GetMapping("getAll")
    public List<StudentDTO> getAll() {
        List<Student> students = studentService.getAll();
        return StudentDTO.convertToDTO(students);
    }

    // Update student
    @PutMapping("update")
    public Boolean updateStudent(@RequestParam Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    // Delete Student
    @DeleteMapping("delete")
    public Boolean deleteStudent(@RequestParam Long id) {
        return studentService.deleteStudent(id);
    }
}