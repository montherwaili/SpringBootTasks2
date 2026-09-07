package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.dto.MemberDTO;
import com.cl.LibraryNetwork.Entities.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    public MemberDTO convertToDTO(Member entity) {
        if (entity == null) return null;
        return MemberDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    public List<MemberDTO> convertToDTO(List<Member> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}