package com.java.kayo.cinevault.controller;

import com.java.kayo.cinevault.Entity.Movie;
import com.java.kayo.cinevault.docs.MovieControllerDoc;
import com.java.kayo.cinevault.mapper.MovieMapper;
import com.java.kayo.cinevault.request.MovieRequest;
import com.java.kayo.cinevault.response.MovieResponse;
import com.java.kayo.cinevault.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinevault/movie")
public class MovieController implements MovieControllerDoc {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/save")
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request) {
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(savedMovie));

    }

    @GetMapping()
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<Movie> movies = movieService.findAll();
        List<MovieResponse> getMovie = movies.stream().map(MovieMapper::toMovieResponse).toList();

        return ResponseEntity.ok(getMovie);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<MovieResponse>> findAllRating() {
        List<Movie> allTopRating = movieService.findAllTopRating();
        List<MovieResponse> getRating = allTopRating.stream().map(MovieMapper::toMovieResponse).toList();

        return ResponseEntity.ok(getRating);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request) {
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category) {
        return ResponseEntity.ok(movieService.findByCategory(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Movie> optMovie = movieService.findById(id);
        if (optMovie.isPresent()) {
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

}
