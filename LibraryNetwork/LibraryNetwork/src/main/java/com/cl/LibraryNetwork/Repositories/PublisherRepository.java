package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {}