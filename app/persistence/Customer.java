package persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import datadefinitions.CustomerType;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long customerId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	private CustomerType customerType;
	private String uvid;
	
	
	@Column(nullable = true, columnDefinition="varchar(4000)")
	private String notes;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) { 
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = StringUtils.abbreviate(notes, 4000);
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public String getUvid() {
		return uvid;
	}

	public void setUvid(String uvid) {
		this.uvid = uvid;
	}
	
	
}
