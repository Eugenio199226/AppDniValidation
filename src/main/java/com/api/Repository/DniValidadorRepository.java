package com.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DniEntity.DniEntity;

@Repository
public interface DniValidadorRepository extends JpaRepository<DniEntity, Long>{

}
