package com.example.technologiesieciowelista1.controllers;

import com.example.technologiesieciowelista1.entity.Loan;
import com.example.technologiesieciowelista1.entity.User;
import com.example.technologiesieciowelista1.repositories.LoanRepository;
import com.example.technologiesieciowelista1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanRepository loanRepository;


    @Autowired
    public LoanController(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Loan addLoan(@RequestBody Loan loan){
        return loanRepository.save(loan);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAllLoan(){
        return loanRepository.findAll();
    }
}

