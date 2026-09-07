package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Fine;
import com.cl.LibraryNetwork.Services.FineService;
import com.cl.LibraryNetwork.dto.FineDTO;
import com.cl.LibraryNetwork.mapper.FineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
@RequiredArgsConstructor
public class FineController {

    private final FineService fineService;
    private final FineMapper fineMapper;

    @PostMapping
    public FineDTO createFine(@RequestBody Fine fine) {
        return fineMapper.convertToDTO(fineService.save(fine));
    }

    @GetMapping
    public List<FineDTO> getAllFines() {
        return fineMapper.convertToDTO(fineService.findAll());
    }

    @GetMapping("/{id}")
    public FineDTO getFineById(@PathVariable Long id) {
        return fineMapper.convertToDTO(fineService.findById(id));
    }

    @PutMapping("/{id}")
    public FineDTO updateFine(@PathVariable Long id, @RequestBody Fine fine) {
        fine.setId(id);
        return fineMapper.convertToDTO(fineService.save(fine));
    }

    @DeleteMapping("/{id}")
    public void deleteFine(@PathVariable Long id) {
        fineService.deleteById(id);
    }
}