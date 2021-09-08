package io.microservices.moviecatalogservice.service;

import io.microservices.moviecatalogservice.model.MovieList;
import io.microservices.moviecatalogservice.model.RatingInfo;

import java.util.List;

import io.microservices.moviecatalogservice.model.CatalogItems;
import io.microservices.moviecatalogservice.model.MovieInfo;

public interface IRatingDataService {

	public RatingInfo getRatingData(MovieInfo movie);
}
