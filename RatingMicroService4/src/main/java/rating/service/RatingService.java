package rating.service;

import java.util.List;

import rating.entity.Rating;

public interface RatingService {

	public Rating saveRating(Rating rating);
	public Rating updateRating(Rating rating);
	public Rating getRatingById(String id);
	public List<Rating> getAllRating();
	public List<Rating> getRatingByUser(String id);
	public void deleteRating(String id);
}
