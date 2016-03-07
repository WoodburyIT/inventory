package controllers;

import java.util.Calendar;

import datadefinitions.AssetType;
import persistence.Asset;
import persistence.Customer;
import persistence.TestEntity;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	@Transactional
    public Result index() {
		System.out.println("in index");
		Asset asset = new Asset();
		
		Customer customer = new Customer();
		customer.setFirstName("John"); 
		customer.setLastName("Jones");
		customer.setEmail("JohnJonesTesting@gmail.com");
		customer.setPhone("801-995-9999");
		customer.setNotes("John has a habit of returning things late -- Michael");
		JPA.em().persist(customer);
        return ok(views.html.index.render("Your new application is ready.")); 
    }
	
	public Result newAssetForm() {
		return ok();
//		return ok(views.html.form.render());
	}
	
	@Transactional
	public Result viewAsset(Long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
		
		return ok(views.html.viewAsset.render(asset));
	}
	
	@Transactional
	public Result editAsset(Long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
		
		return ok(views.html.viewAsset.render(asset));
	}
	
	public Result newAssetForm(){
		
	}

}
