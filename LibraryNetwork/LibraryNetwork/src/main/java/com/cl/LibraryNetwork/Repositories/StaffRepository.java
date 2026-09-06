package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {}