package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import datadefinitions.AssetType;
import datadefinitions.CustomerType;
import persistence.Asset;
import persistence.Customer;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.InvUtil;
import util.SessionHandler;

public class EditData extends Controller{
	
	public Result addAssetToCart(Long assetId) {
		System.out.println("assetId : " + assetId);
		Set<Long> ids = SessionHandler.setFromCookie(session().get("assetsInCart"));
		ids.add(assetId);
		System.out.println("ids : " + ids);
		session().put("assetsInCart", SessionHandler.toCookie(ids));
		return status(204);
	}
	
	public Result assignCustomerToCart(Long customerId) {
		System.out.println("customerId : " + customerId);
		session().put("customerInCart", SessionHandler.toCookie(customerId));
		System.out.println("session: " + session());
		return status(204);
	}
	
	public Result removeAssetFromCart(Long assetId) {
		Set<Long> ids = SessionHandler.setFromCookie(session().get("assetsInCart"));
		ids.remove(assetId);
		session().put("assetsInCart", SessionHandler.toCookie(ids));
		System.out.println("ids : " + ids);
		return ok();
	}
	
	public Result removeCutomerFromCart() {
		session().remove("customerInCart");
		return ok();
	}
	
	public Result clearCart() {
		session().remove("assetsInCart");
		session().remove("customerInCart");
		return ok();
	}
	
	@Transactional
	public  Result editCustomer(Long customerId) throws ParseException{ 
		System.out.println("editing customer : " + customerId);
		DynamicForm requestData = Form.form().bindFromRequest();
		String firstName = requestData.get("firstName");
		String lastName = requestData.get("lastName");
		String email = requestData.get("email");
		String phone = requestData.get("phone");
		String notes = requestData.get("notes");
		String uvid = requestData.get("uvid");
		String customerTypeString = requestData.get("customerType");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		System.out.println("email : " + email);
		System.out.println("phone : " + phone);
		System.out.println("notes : " + notes);
		System.out.println("uvid : " + uvid);
		System.out.println("customerType : " + customerTypeString);
		
		
		Customer customer;
		if(customerId == null || customerId ==0){
			customer = new Customer();
		}
		else{
			customer = JPA.em().find(Customer.class, customerId);
		}
		
		CustomerType customerType = CustomerType.valueOf(customerTypeString);
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setNotes(notes);
		customer.setUvid(uvid);
		customer.setCustomerType(customerType);
		
		
		customer = JPA.em().merge(customer);
		System.out.println("great success !");
		return redirect("/customer?customerId=" + customer.getCustomerId());
	}
	
	@Transactional
	public Result deleteCustomer(Long customerId) throws ParseException{
		return ok();
	}
	
	@Transactional
	public Result editAsset(Long assetId) throws ParseException{
		DynamicForm requestData = Form.form().bindFromRequest();
		String inventoryNumber = requestData.get("inventoryNumber");
		String name = requestData.get("name");
		String description = requestData.get("description");
		String purchaseDateString = requestData.get("purchaseDate");
		String priorityLevelString = requestData.get("priorityLevel");
		String assetType = requestData.get("assetType");
		String dateLostString = requestData.get("dateLost");
		
		Date purchaseDate = null;
		Date dateLost = null;
		if(purchaseDateString != null){
			purchaseDate = InvUtil.getDateFormat().parse(purchaseDateString);
			System.out.println("purchaseDate : " + purchaseDate);
		}
		if(dateLostString != null){
			dateLost = InvUtil.getDateFormat().parse(dateLostString);
			System.out.println("dateLost : " + dateLost);
		}
		
		
		
		Integer priorityLevel = Integer.parseInt(priorityLevelString);
		
		Asset asset;
		if(assetId == null || assetId == 0){
			asset = new Asset();
		}
		else{
			asset = JPA.em().find(Asset.class, assetId);
		}
		
		asset.setInventoryNumber(inventoryNumber);
		asset.setName(name);
		asset.setDescription(description);
		asset.setPurchaseDate(purchaseDate);
		asset.setDateLost(dateLost);
		asset.setPriorityLevel(priorityLevel);
		asset.setAssetType(assetType);
		
		asset = JPA.em().merge(asset);
		
		return redirect("/asset?assetId=" + asset.getAssetId());
	}
	
	@Transactional
	public Result deleteAsset(Long assetId) throws ParseException{

		return ok();
	}
	

}
