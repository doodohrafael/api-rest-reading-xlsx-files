package com.rafael.readingxlsxfiles.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafael.readingxlsxfiles.domain.model.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {

}
