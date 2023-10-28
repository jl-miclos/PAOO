package com.fatec.ourtub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.ourtub.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
