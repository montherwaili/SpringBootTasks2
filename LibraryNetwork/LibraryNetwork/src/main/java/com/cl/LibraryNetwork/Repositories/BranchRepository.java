package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {}