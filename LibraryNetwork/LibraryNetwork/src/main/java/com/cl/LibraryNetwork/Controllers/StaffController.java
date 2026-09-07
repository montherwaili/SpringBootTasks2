package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Staff;
import com.cl.LibraryNetwork.Services.StaffService;
import com.cl.LibraryNetwork.dto.StaffDTO;
import com.cl.LibraryNetwork.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;
    private final StaffMapper staffMapper;

    @PostMapping
    public StaffDTO createStaff(@RequestBody Staff staff) {
        return staffMapper.convertToDTO(staffService.save(staff));
    }

    @GetMapping
    public List<StaffDTO> getAllStaff() {
        return staffMapper.convertToDTO(staffService.findAll());
    }

    @GetMapping("/{id}")
    public StaffDTO getStaffById(@PathVariable Long id) {
        return staffMapper.convertToDTO(staffService.findById(id));
    }

    @PutMapping("/{id}")
    public StaffDTO updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id);
        return staffMapper.convertToDTO(staffService.save(staff));
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteById(id);
    }
}