package com.java.kayo.cinevault.repository;

import com.java.kayo.cinevault.Entity.Category;
import com.java.kayo.cinevault.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(Category categories);

    List<Movie> findTop5ByOrderByRatingDesc();

}
