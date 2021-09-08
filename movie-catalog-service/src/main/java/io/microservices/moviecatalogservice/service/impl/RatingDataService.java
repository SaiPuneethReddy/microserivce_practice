package io.microservices.moviecatalogservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservices.moviecatalogservice.model.CatalogItems;
import io.microservices.moviecatalogservice.model.MovieInfo;
import io.microservices.moviecatalogservice.model.MovieList;
import io.microservices.moviecatalogservice.model.RatingInfo;
import io.microservices.moviecatalogservice.service.IRatingDataService;
@Component
public class RatingDataService implements IRatingDataService {
	@Autowired
	public RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod="getRatingDataFallbackMethod")
	public RatingInfo getRatingData(MovieInfo movie) {
		
			RatingInfo ratingInfo = restTemplate.getForObject("http://rating-data-service/rating/" + movie.getMovieId(),
					RatingInfo.class);
		

		return ratingInfo;
	}
	public RatingInfo getRatingDataFallbackMethod(MovieInfo movie) {
		return new RatingInfo(-1, -1);
	}

}
