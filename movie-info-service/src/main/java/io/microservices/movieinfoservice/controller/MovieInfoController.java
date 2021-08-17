package io.microservices.movieinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservices.moviecatalogservice.model.MovieInfo;
import io.microservices.moviecatalogservice.model.MovieList;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {
	@GetMapping("/list")
	public MovieList getMovieInfoList() {
		ArrayList<MovieInfo> movieList = new ArrayList<MovieInfo>();		
		movieList.add(new MovieInfo(1,"RushHour","RushHour is comedy movie."));
		movieList.add(new MovieInfo(2,"Tenet","Tenet is Sci-Fi movie."));
		
		return new MovieList(movieList);
	}

}
