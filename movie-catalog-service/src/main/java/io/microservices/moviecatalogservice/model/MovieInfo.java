package io.microservices.moviecatalogservice.model;

public class MovieInfo {
	private int movieId;
	private String movieName;
	private String movieDescription;

	public MovieInfo() {		
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public MovieInfo(int movieId, String movieName, String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "MovieInfo [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ "]";
	}

}
