package io.microservices.moviecatalogservice.model;

public class RatingInfo {
private int id;
private int rating;
public RatingInfo(int id, int rating) {
	this.id = id;
	this.rating = rating;
}
public RatingInfo() {

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
