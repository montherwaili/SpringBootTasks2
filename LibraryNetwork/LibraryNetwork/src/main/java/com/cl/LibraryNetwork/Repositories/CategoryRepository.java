package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}