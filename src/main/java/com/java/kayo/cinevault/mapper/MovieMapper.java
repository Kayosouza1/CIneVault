package com.java.kayo.cinevault.mapper;

import com.java.kayo.cinevault.Entity.Category;
import com.java.kayo.cinevault.Entity.Movie;
import com.java.kayo.cinevault.Entity.Streaming;
import com.java.kayo.cinevault.request.MovieRequest;
import com.java.kayo.cinevault.response.CategoryResponse;
import com.java.kayo.cinevault.response.MovieResponse;
import com.java.kayo.cinevault.response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {


    public static Movie toMovie(MovieRequest request) {

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();


    }


    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

}
