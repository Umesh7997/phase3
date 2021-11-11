package com.springboot.phase3.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.phase3.model.Buynow;

@Repository
public interface BuynowRepository extends JpaRepository<Buynow, Long>{

	

	Optional<Buynow> findById(Long id);

}