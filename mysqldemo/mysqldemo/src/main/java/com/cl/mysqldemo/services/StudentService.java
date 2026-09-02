package com.cl.mysqldemo.services;

import com.cl.mysqldemo.dto.StudentDTO;
import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.entities.Student;
import com.cl.mysqldemo.repositories.SchoolRepository;
import com.cl.mysqldemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    private final SchoolService schoolService;
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public StudentService(SchoolService schoolService, StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.schoolService = schoolService;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    // Add student
    public StudentDTO addStudent(StudentDTO studentDTO) {
        if (studentDTO == null || studentDTO.getSchoolId() == null) {
            return null;
        }
        Student student = new Student();
        student.setName(name);
        student.setMajor(major);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setPhoneNumber(parentName);

        student.setIsActive(true);
        student.setCreatedDate(new Date());
        Student savedStudent = studentRepository.save(student);

       List<Student> studentList = school.getStudents();
       studentList.add(savedStudent);
       school.setStudents(studentList);
       schoolRepository.save(school);

        return savedStudent.getId();
    }
}
