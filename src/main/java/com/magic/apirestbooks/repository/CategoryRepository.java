package com.magic.apirestbooks.repository;

import com.magic.apirestbooks.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
