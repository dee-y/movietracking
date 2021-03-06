package ua.romankh3.movie.tracking.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.romankh3.movie.tracking.exception.NotFoundException;
import ua.romankh3.movie.tracking.exception.ValidationException;
import ua.romankh3.movie.tracking.mapper.MovieTMDB;
import ua.romankh3.movie.tracking.rest.entity.WatchedMovieEntity;
import ua.romankh3.movie.tracking.service.MovieService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/watched")
    public void markMovieWatched(@RequestBody @Valid WatchedMovieEntity watchedMovieEntity) throws NotFoundException {

        movieService.markMovieAsWatched(watchedMovieEntity);
    }

    @PostMapping("/unwatched")
    public void markMovieUnwatched(@RequestBody @Valid WatchedMovieEntity watchedMovieEntity) throws NotFoundException {

        movieService.markMovieAsUnWatched(watchedMovieEntity);
    }

    @GetMapping("/{user_id}")
    public List<MovieTMDB> getUnwatchedMoviesWithFavoriteActors(@PathVariable("user_id") Integer userId)
            throws NotFoundException {

        return movieService.retrieveMoviesByFavoriteActors(userId);
    }

    @GetMapping("/{user_id}/{year}/")
    public List<MovieTMDB> getUnwatchedMoviesWithFavoriteActorsWithYear(@PathVariable("user_id") Integer userId,
                                                                        @PathVariable("year") Integer year) throws NotFoundException, ValidationException {

        return movieService.retrieveMoviesByActorsAndReleaseYear(userId, year);
    }

    @GetMapping("/{user_id}/{year}/{month}")
    public List<MovieTMDB> getUnwatchedMoviesWithFavoriteActorsWithYear(@PathVariable("user_id") Integer userId,
                                                                        @PathVariable("year") Integer year,
                                                                        @PathVariable("month") Integer month) throws NotFoundException, ValidationException, IOException {

        return movieService.retrieveMoviesByActorsAndReleaseMonth(userId, year, month);
    }
}
