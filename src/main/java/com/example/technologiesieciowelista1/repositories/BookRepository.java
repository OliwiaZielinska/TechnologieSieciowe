package com.example.technologiesieciowelista1.repositories;

import com.example.technologiesieciowelista1.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
