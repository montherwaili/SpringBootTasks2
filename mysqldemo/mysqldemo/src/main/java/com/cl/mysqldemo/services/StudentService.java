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


        School school = schoolService.getById(studentDTO.getSchoolId());
        if (school == null || Boolean.FALSE.equals(school.getIsActive())) {
            return null;
        }

        Student student = StudentDTO.toEntity(studentDTO);
        student.setIsActive(true);
        student.setCreatedDate(new Date());

        Student savedStudent = studentRepository.save(student);

        // protect if school is null
        List<Student> studentList = school.getStudents();
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
        studentList.add(savedStudent);
        school.setStudents(studentList);
        schoolRepository.save(school);

        return StudentDTO.convertToDTO(savedStudent);
    }

    // get by ID
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    //get All
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    //Update Student
    public Boolean updateStudent(Long id, StudentDTO dto) {
        Student student = getById(id);
        if (student == null || Boolean.FALSE.equals(student.getIsActive())) {
            return false;
        }

        if (dto.getStudentName() != null) student.setName(dto.getStudentName());
        if (dto.getMajor() != null) student.setMajor(dto.getMajor());
        if (dto.getGender() != null) student.setGender(dto.getGender());
        if (dto.getPhoneNumber() != null) student.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getParentName() != null) student.setParentName(dto.getParentName());

        student.setUpdatedDate(new Date());
        studentRepository.save(student);
        return true;
    }

    // Soft Delete Student
    public Boolean deleteStudent(Long id) {
        Student student = getById(id);
        if (student == null || Boolean.FALSE.equals(student.getIsActive())) {
            return false;
        }

        return savedStudent.getId();
    }
}
