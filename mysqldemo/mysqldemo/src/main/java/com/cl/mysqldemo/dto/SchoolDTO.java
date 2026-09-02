package com.cl.mysqldemo.dto;

import com.cl.mysqldemo.entities.School;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO {
    private Long schoolId;
    private String schoolName;
    private String schoollocation;


    public static SchoolDTO convertToDTO(School entity) {


        SchoolDTO dto = SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoollocation(entity.getLocation())
                .build();
        return dto;
    }

    public static List<SchoolDTO> convertToDTO(List<School> entityList) {

        List<SchoolDTO> dtos = new ArrayList<>();
        for (School s : entityList) {
            dtos.add(convertToDTO(s));
        }
        return dtos;
    }

}

