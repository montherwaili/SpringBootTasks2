package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {}