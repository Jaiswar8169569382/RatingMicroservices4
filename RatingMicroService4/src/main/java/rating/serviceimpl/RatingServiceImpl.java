package rating.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rating.entity.Rating;
import rating.exception.RatingNoFoundWithId;
import rating.repository.RatingRepository;
import rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating saveRating(Rating rating) {
		String ratingId=UUID.randomUUID().toString();
		rating.setRid(ratingId);
		
		Rating ratings=this.ratingRepository.save(rating);
		return ratings;
	}

	@Override
	public Rating updateRating(Rating rating) {
		// TODO Auto-generated method stub
		return this.ratingRepository.save(rating);
	}

	@Override
	public Rating getRatingById(String id) {
		// TODO Auto-generated method stub
		return this.ratingRepository.findById(id).orElseThrow(()->new RatingNoFoundWithId("Rating not found with register id"));
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUser(String id) {
		// TODO Auto-generated method stub
		
		
		return this.ratingRepository.findByUserid(id);
	}

	@Override
	public void deleteRating(String id) {
		// TODO Auto-generated method stub
		this.ratingRepository.deleteById(id);
	}

	
}
