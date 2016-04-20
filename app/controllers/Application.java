package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import datadefinitions.AssetType;
import persistence.Asset;
import persistence.CheckoutEvent;
import persistence.CheckoutLineItem;
import persistence.Customer;
import persistence.ScheduledCheckout;
import persistence.TestEntity;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import util.CheckoutDAO;
import util.InvUtil;
import util.SessionHandler;
import views.html.*;

public class Application extends Controller {

	@Transactional
    public Result index() {
		List<ScheduledCheckout> scheds =CheckoutDAO.getScheduledCheckouts();
		System.out.println("scheds : " + scheds.size());
		return ok(Json.toJson(scheds)); 
    }
	
	public Result testing() {
		return ok(views.html.testing.render());
	}
	
	@Transactional
	public Result calendar() {
		return ok(views.html.calendar.render());
	}
	
	@Transactional
	public Result scheduleCheckoutForm() {
		return ok(views.html.scheduleCheckoutForm.render());
	}
	
	@Transactional
	public Result immediateCheckoutForm() {
		return ok(views.html.immediateCheckoutForm.render());
	}
	
	@Transactional
	public Result viewCheckouts() {
		List<CheckoutEvent> checkouts = JPA.em().createQuery("from CheckoutEvent ce", CheckoutEvent.class).getResultList();
		System.out.println("checkouts size : " + checkouts.size());
		return ok(views.html.checkouts.render(checkouts));
	}
	
	@Transactional
	public Result viewPastCheckouts(int count, int offset) {
		List<CheckoutEvent> checkouts = CheckoutDAO.getAllCheckoutEvents(count, offset);
		List<ScheduledCheckout> scheduledCheckouts = CheckoutDAO.getScheduledCheckouts();
		return ok(views.html.allCheckouts.render(checkouts, scheduledCheckouts));
	}
	
	@Transactional
	public Result viewScheduledCheckouts() {
		List<ScheduledCheckout> checkouts = CheckoutDAO.getScheduledCheckouts();
		System.out.println("checkouts size : " + checkouts.size());
		return ok(views.html.scheduledCheckouts.render(checkouts));
	}
	
	@Transactional
	public Result viewAssets(){
		List<Asset> assets = JPA.em().createQuery("from Asset a", Asset.class).getResultList();
		System.out.println("viewing assets : " + assets.size());
		return ok(views.html.assetList.render(assets));
	}
	
	@Transactional
	public Result viewCustomers() {
		List<Customer> customers = JPA.em().createQuery("from Customer c", Customer.class).getResultList();
		System.out.println("viewing customers : " + customers.size());
		return ok(views.html.customerList.render(customers));
	}
	
	@Transactional
	public Result viewAsset(Long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
		
		return ok(views.html.viewAsset.render(asset));
	}
	
	@Transactional
	public Result viewCustomer(Long customerId) {
		Customer customer= JPA.em().find(Customer.class, customerId);
		return ok(views.html.viewCustomer.render(customer));
	}
	
	@Transactional
	public Result editAssetForm(Long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
		
		return ok(views.html.assetForm.render(asset));
	}
	
	public Result newAssetForm(){
		return ok(views.html.assetForm.render(null));
	}
	
	public Result newCustomerForm() {
		return ok(views.html.customerForm.render(null));
	}
	
	@Transactional
	public Result editCustomerForm(Long customerId) {
		Customer customer = JPA.em().find(Customer.class, customerId);
		return ok(views.html.customerForm.render(customer));
	}

}
