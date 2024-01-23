package com.example.object.ch2.v1.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.object.ch2.v1.Movie;


@SpringBootTest
class MovieRepositoryTest {
	@Autowired
	private MovieRepository movieRepository;

	@Test
	void findMovieById() {
		Optional<Movie> movie = movieRepository.findById(1L);
		movie.ifPresent(movie1 -> System.out.println(movie1.getFee()));
	}
}