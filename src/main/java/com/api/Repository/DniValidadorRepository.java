package com.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.DniEntity;

@Repository
public interface DniValidadorRepository extends JpaRepository<DniEntity, Long>{

}
