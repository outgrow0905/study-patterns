package com.example.object.ch2.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.object.ch2.v1.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
