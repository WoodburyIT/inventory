package persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CheckoutLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long checkoutLineItemId;
	
	@ManyToOne
	private CheckoutEvent checkoutEvent;
	
	@ManyToOne
	private Asset asset;
	
	private Date dateCheckedIn;
	public long getCheckoutLineItemId() {
		return checkoutLineItemId;
	}
	public void setCheckoutLineItemId(long checkoutLineItemId) {
		this.checkoutLineItemId = checkoutLineItemId;
	}
	public CheckoutEvent getCheckoutEvent() {
		return checkoutEvent;
	}
	public void setCheckoutEvent(CheckoutEvent checkoutEvent) {
		this.checkoutEvent = checkoutEvent;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Date getDateCheckedIn() {
		return dateCheckedIn;
	}
	public void setDateCheckedIn(Date dateCheckedIn) {
		this.dateCheckedIn = dateCheckedIn;
	}
	
	
}
