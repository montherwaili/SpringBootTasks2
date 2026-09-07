package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Loan;
import com.cl.LibraryNetwork.Services.LoanService;
import com.cl.LibraryNetwork.dto.LoanDTO;
import com.cl.LibraryNetwork.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    @PostMapping
    public LoanDTO createLoan(@RequestBody Loan loan) {
        return loanMapper.convertToDTO(loanService.save(loan));
    }

    @GetMapping
    public List<LoanDTO> getAllLoans() {
        return loanMapper.convertToDTO(loanService.findAll());
    }

    @GetMapping("/{id}")
    public LoanDTO getLoanById(@PathVariable Long id) {
        return loanMapper.convertToDTO(loanService.findById(id));
    }

    @PutMapping("/{id}")
    public LoanDTO updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        loan.setId(id);
        return loanMapper.convertToDTO(loanService.save(loan));
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteById(id);
    }
}