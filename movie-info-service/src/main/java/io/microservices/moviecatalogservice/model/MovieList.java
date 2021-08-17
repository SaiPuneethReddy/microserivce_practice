package io.microservices.moviecatalogservice.model;

import java.util.List;

public class MovieList {
private List<MovieInfo> movieinfo;

public List<MovieInfo> getMovieinfo() {
	return movieinfo;
}

public void setMovieinfo(List<MovieInfo> movieinfo) {
	this.movieinfo = movieinfo;
}

public MovieList(List<MovieInfo> movieinfo) {
	super();
	this.movieinfo = movieinfo;
}

public MovieList() {
	
}

}
