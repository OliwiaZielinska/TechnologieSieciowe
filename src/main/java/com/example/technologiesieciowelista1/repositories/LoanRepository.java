package com.example.technologiesieciowelista1.repositories;

import com.example.technologiesieciowelista1.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
