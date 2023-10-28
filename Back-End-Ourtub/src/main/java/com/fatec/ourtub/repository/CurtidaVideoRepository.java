package com.fatec.ourtub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.ourtub.model.CurtidaVideo;

@Repository
public interface CurtidaVideoRepository extends JpaRepository<CurtidaVideo, Long> {

}
