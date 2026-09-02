package com.cl.mysqldemo.services;

import com.cl.mysqldemo.dto.SchoolDTO;
import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO createSchool(SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.getSchoolName());
        school.setLocation(schoolDTO.getSchoolLocation());
        school.setIsActive(true);
        school.setCreatedDate(new Date());

        School savedSchool = schoolRepository.save(school);
        return SchoolDTO.convertToDTO(savedSchool);
    }

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchool();
    }

    public School getById(Long id) {
        return schoolRepository.getById(id);
    }

    public SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO) {
        School schoolToUpdate = schoolRepository.getById(id);
        if (schoolToUpdate == null) {
            return null;
        }
        schoolToUpdate.setUpdatedDate(new Date());
        schoolToUpdate.setName(schoolDTO.getSchoolName());
        schoolToUpdate.setLocation(schoolDTO.getSchoolLocation());

        School updatedSchool = schoolRepository.save(schoolToUpdate);
        return SchoolDTO.convertToDTO(updatedSchool);
    }

    public Boolean deleteById(Long id) {
        School schoolToUpdate = schoolRepository.getById(id);
        if (schoolToUpdate == null) {
            return false;
        }
        schoolToUpdate.setIsActive(false);
        schoolToUpdate.setUpdatedDate(new Date());
        schoolRepository.save(schoolToUpdate);
        return true;
    }
}
