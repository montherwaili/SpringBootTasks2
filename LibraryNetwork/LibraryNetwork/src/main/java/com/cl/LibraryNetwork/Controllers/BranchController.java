package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Branch;
import com.cl.LibraryNetwork.Services.BranchService;
import com.cl.LibraryNetwork.dto.BranchDTO;
import com.cl.LibraryNetwork.mapper.BranchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;
    private final BranchMapper branchMapper;

    @PostMapping
    public BranchDTO createBranch(@RequestBody Branch branch) {
        return branchMapper.convertToDTO(branchService.save(branch));
    }

    @GetMapping
    public List<BranchDTO> getAllBranches() {
        return branchMapper.convertToDTO(branchService.findAll());
    }

    @GetMapping("/{id}")
    public BranchDTO getBranchById(@PathVariable Long id) {
        return branchMapper.convertToDTO(branchService.findById(id));
    }

    @PutMapping("/{id}")
    public BranchDTO updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        branch.setId(id);
        return branchMapper.convertToDTO(branchService.save(branch));
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteById(id);
    }
}