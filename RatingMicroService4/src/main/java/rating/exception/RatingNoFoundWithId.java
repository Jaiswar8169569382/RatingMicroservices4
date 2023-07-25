package rating.exception;

public class RatingNoFoundWithId extends RuntimeException{

	public RatingNoFoundWithId()
	{
		super("Rating not found with this register id");
	}
	
	public RatingNoFoundWithId(String sms)
	{
		super(sms);
	}
}
