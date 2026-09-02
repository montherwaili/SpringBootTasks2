package com.cl.mysqldemo.controllers;

import com.cl.mysqldemo.dto.SchoolDTO;
import com.cl.mysqldemo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("add")
    public SchoolDTO addSchool(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.createSchool(schoolDTO);
    }

    @GetMapping("getAll")
    public List<SchoolDTO> getAllSchools() {
        return SchoolDTO.convertToDTO(schoolService.getAllSchools());
    }

    @GetMapping("getById")
    public SchoolDTO getById(@RequestParam Long id) {
        return SchoolDTO.convertToDTO(schoolService.getById(id));
    }

    @PutMapping("update")
    public SchoolDTO updateSchool(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String location) {
        return SchoolDTO.convertToDTO(schoolService.updateSchool(id, name, location));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteSchool(@RequestParam Long id){
        return schoolService.deleteById(id);
    }
}
