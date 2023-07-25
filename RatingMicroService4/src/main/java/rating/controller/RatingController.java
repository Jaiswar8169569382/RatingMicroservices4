package rating.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rating.entity.Rating;
import rating.repository.RatingRepository;
import rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating)
	{
		Rating ratings=this.ratingService.saveRating(rating);
	    return new ResponseEntity<Rating>(ratings,HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating)
	{
		Rating ratings=this.ratingService.updateRating(rating);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/{rid}")
	public ResponseEntity<Rating> getRatingById(@PathVariable("rid") String rid)
	{
		Rating rating=this.ratingService.getRatingById(rid);
		return ResponseEntity.ok(rating);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating()
	{
		List<Rating> ratings=this.ratingService.getAllRating();
		
		return ResponseEntity.ok(ratings);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable("uid") String uid)
	{
		List<Rating> ratings=this.ratingService.getRatingByUser(uid);
		return ResponseEntity.ok(ratings);
	}
	
	@DeleteMapping("/{rid}")
	public void deleteRating(@PathVariable("rid") String rid)
	{
		this.ratingService.deleteRating(rid);
	}
}
