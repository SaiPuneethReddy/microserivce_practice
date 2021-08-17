package io.microservices.moviecatalogservice.model;

public class CatalogItems {
	public CatalogItems(int movieId, String movieName, String movieDescription, int rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.rating = rating;
	}

	public CatalogItems() {	
	}

	private int movieId;
	private String movieName;
	private String movieDescription;
	private int rating;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "CatalogItems [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription="
				+ movieDescription + ", rating=" + rating + "]";
	}

	

}
