package persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ScheduledCheckout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long scheduledCheckoutId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="checkoutEvent") 
	private List<CheckoutLineItem> lineItems = new ArrayList<CheckoutLineItem>();
	
	@ManyToOne
	private Customer customer;

	private Date scheduledDate;
	private Date dueDate;
	@Column(nullable = true, columnDefinition="varchar(4000)")
	private String notes;
	private String assignedTo;
	
	
	public long getScheduledCheckoutId() {
		return scheduledCheckoutId;
	}
	public void setScheduledCheckoutId(long scheduledCheckoutId) {
		this.scheduledCheckoutId = scheduledCheckoutId;
	}
	public List<CheckoutLineItem> getLineItems() {
		return lineItems;
	}
	public boolean addLineItem(CheckoutLineItem lineItem) {
		return this.lineItems.add(lineItem);
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
