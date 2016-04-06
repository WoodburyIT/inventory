package controllers;

import java.util.Calendar;
import java.util.List;

import datadefinitions.AssetType;
import persistence.Asset;
import persistence.Customer;
import persistence.TestEntity;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import util.CheckoutDAO;
import views.html.*;

public class Application extends Controller {

	@Transactional
    public Result index() {
		List<Asset> assets = CheckoutDAO.getCheckedOutAssets();
		System.out.println("assets : " + assets.size());
        return ok(views.html.index.render("Your new application is ready.")); 
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
