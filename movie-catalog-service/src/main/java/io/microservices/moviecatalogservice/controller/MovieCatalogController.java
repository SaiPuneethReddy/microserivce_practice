package io.microservices.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservices.moviecatalogservice.model.CatalogItems;
import io.microservices.moviecatalogservice.model.MovieInfo;
import io.microservices.moviecatalogservice.model.MovieList;
import io.microservices.moviecatalogservice.model.RatingInfo;
import io.microservices.moviecatalogservice.service.IMovieInfoService;
import io.microservices.moviecatalogservice.service.IRatingDataService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public IMovieInfoService movieInfoService;
	@Autowired
	public IRatingDataService ratingDataService;

	@SuppressWarnings("restriction")
	@GetMapping("/list")
	// @HystrixCommand(fallbackMethod="getMovieInfoFallback")
	public List<CatalogItems> getMovieInfo() {
		MovieList movieList = movieInfoService.getMovieList();

		List<CatalogItems> catalogList = (List<CatalogItems>) movieList.getMovieinfo().stream().map(movie -> {
			RatingInfo ratingInfo = ratingDataService.getRatingData(movie);
			return new CatalogItems(movie.getMovieId(), movie.getMovieName(), movie.getMovieDescription(),
					ratingInfo.getRating());
		}).collect(Collectors.toList());

		return catalogList;

	}
//	public List<CatalogItems> getMovieInfoFallback() {
//		return (List<CatalogItems>) Arrays.asList(new CatalogItems(-1,"noMovies","noMovies",-1));
//		
//	}

	@GetMapping("/{id}")
	public RatingInfo getRatingInfo(@PathVariable("id") int id) {
		RatingInfo ratingInfo = restTemplate.getForObject("http://localhost:8083/rating/" + id, RatingInfo.class);

		return ratingInfo;

	}

}
