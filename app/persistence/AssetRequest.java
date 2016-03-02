package persistence;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AssetRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long checkoutId;
	
	private Customer customer;
	private Asset asset;

	private Date requested;
	private Date dueDate;
	
	private String checkedOutBy;
}
