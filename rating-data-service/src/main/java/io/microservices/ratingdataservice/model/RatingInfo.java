package io.microservices.ratingdataservice.model;

public class RatingInfo {
private int id;
private int rating;
public RatingInfo(int id, int rating) {
	super();
	this.id = id;
	this.rating = rating;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public RatingInfo() {
	
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
@Override
public String toString() {
	return "RatingInfo [id=" + id + ", rating=" + rating + "]";
}
}
