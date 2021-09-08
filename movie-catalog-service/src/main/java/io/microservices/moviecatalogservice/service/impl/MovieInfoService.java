package io.microservices.moviecatalogservice.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservices.moviecatalogservice.model.MovieInfo;
import io.microservices.moviecatalogservice.model.MovieList;
import io.microservices.moviecatalogservice.service.IMovieInfoService;
@Component
public class MovieInfoService implements IMovieInfoService {
	@Autowired
	public RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod="getMovieListFallbackMethod")
	public MovieList getMovieList() {
		MovieList movieList=restTemplate.getForObject("http://movie-info-service/movieInfo/list",MovieList.class);
		return movieList;
	}
	
	public MovieList getMovieListFallbackMethod() {
		MovieList movieList=new MovieList(Arrays.asList(new MovieInfo(-1,"NoMovie","NoMovie")));
		return movieList;
	}
}
