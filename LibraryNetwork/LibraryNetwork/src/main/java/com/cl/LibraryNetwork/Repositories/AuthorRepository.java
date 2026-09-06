package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {}