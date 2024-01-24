package com.example.object.ch2.v1.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.object.ch2.v1.Movie;
import com.example.object.ch2.v1.Reservation;
import com.example.object.ch2.v1.Screening;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MovieRepositoryTest {
	@Autowired
	private MovieRepository movieRepository;

	@Test
	@Transactional
	void findMovieById() {
		Optional<Movie> movie = movieRepository.findById(1L);
		if (!movie.isPresent()) {
			throw new RuntimeException();
		}

		Movie movie1 = movie.get();
		Screening screening = Screening.builder()
			.movie(movie1)
			.startTime(LocalDateTime.now())
			.endTime(LocalDateTime.now())
			.sequence(1)
			.build();

		Reservation reservation = screening.reserve(2);
		log.info("reservation: {}", reservation);
	}
}