package com.cl.mysqldemo.dto;

import com.cl.mysqldemo.entities.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentId;
    private String studentName;
    private String major;
    private String gender;
    private String phoneNumber;
    private String parentName;
    private Long schoolId;

    public static StudentDTO convertToDTO(Student entity) {

        StudentDTO dto = StudentDTO.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .gender(entity.getGender())
                .build();

        return dto;
    }

    public static List<StudentDTO> convertToDTO(List<Student> entityList) {

        List<StudentDTO> dtos = new ArrayList<>();

        for (Student student : entityList) {
            dtos.add(convertToDTO(student));
        }

        return dtos;
    }
}