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
    private String schoolLocation;

    public static SchoolDTO convertToDTO(School entity) {
        if (entity == null || entity.getId() == null) {
            return null;
        }

        return SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();
    }

    public static List<SchoolDTO> convertToDTO(List<School> entityList) {
        List<SchoolDTO> dtos = new ArrayList<>();
        if (entityList != null) {
            for (School s : entityList) {
                SchoolDTO dto = convertToDTO(s);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }
