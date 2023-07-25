package rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	public List<Rating> findByUserid(String userid);
	public List<Rating> findByHotelid(String hotelid);
}
