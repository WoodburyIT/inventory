package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CheckoutEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long checkoutEventId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="checkoutEvent") 
	private List<CheckoutLineItem> lineItems = new ArrayList<CheckoutLineItem>();
	
	@ManyToOne
	private Customer customer;

	private Date checkoutDate;
	private Date dueDate;
	
	private String checkedOutBy;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getCheckedOutBy() {
		return checkedOutBy;
	}

	public void setCheckedOutBy(String checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}

	public long getCheckoutEventId() {
		return checkoutEventId;
	}

	public void setCheckoutEventId(long checkoutEventId) {
		this.checkoutEventId = checkoutEventId;
	}

	public List<CheckoutLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<CheckoutLineItem> lineItems) {
		this.lineItems.clear();
		this.lineItems.addAll(lineItems);
	}
	
	
}
