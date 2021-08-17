package io.microservices.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sun.tools.javac.util.List;

import io.microservices.moviecatalogservice.model.CatalogItems;
import io.microservices.moviecatalogservice.model.MovieInfo;
import io.microservices.moviecatalogservice.model.MovieList;
import io.microservices.moviecatalogservice.model.RatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	public RestTemplate restTemplate;

	@SuppressWarnings("restriction")
	@GetMapping("/list")
	public ArrayList<CatalogItems> getMovieInfo() {
		MovieList movieList=restTemplate.getForObject("http://movie-info-service/movieInfo/list",MovieList.class);
		
		ArrayList<CatalogItems> catalogList= (ArrayList<CatalogItems>) movieList.getMovieinfo().stream().map(movie -> {
			RatingInfo ratingInfo=restTemplate.getForObject("http://rating-data-service/rating/"+movie.getMovieId(), RatingInfo.class);
			return new CatalogItems(movie.getMovieId(),movie.getMovieName(),movie.getMovieDescription(),ratingInfo.getRating());
		}).collect(Collectors.toList());
		
		
		return   catalogList;
	
	}
	
	@GetMapping("/{id}")
	public RatingInfo getRatingInfo(@PathVariable("id") int id) {
		RatingInfo ratingInfo=restTemplate.getForObject("http://localhost:8083/rating/"+id, RatingInfo.class);
		
		return ratingInfo;
	
	}

}
