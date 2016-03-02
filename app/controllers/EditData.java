package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import datadefinitions.AssetType;
import persistence.Asset;
import persistence.Customer;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class EditData extends Controller{
	
	
	@Transactional
	public Result editCustomer(Long customerId) throws ParseException{
		DynamicForm requestData = Form.form().bindFromRequest();
		String firstName = requestData.get("firstName");
		String lastName = requestData.get("lastName");
		String email = requestData.get("email");
		String phone = requestData.get("phone");
		String notes = requestData.get("notes");
		
		Customer customer = JPA.em().find(Customer.class, customerId);
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setNotes(notes);
		
		return ok();
	}
	
	@Transactional
	public Result newCustomer() throws ParseException{
		DynamicForm requestData = Form.form().bindFromRequest();
		String firstName = requestData.get("firstName");
		String lastName = requestData.get("lastName");
		String email = requestData.get("email");
		String phone = requestData.get("phone");
		String notes = requestData.get("notes");
		
		Customer customer = new Customer();
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setNotes(notes);
		
		JPA.em().persist(customer);
		
		return ok();
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
		String assetTypeString = requestData.get("assetType");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date purchaseDate = formatter.parse(purchaseDateString);
		
		Integer priorityLevel = Integer.parseInt(priorityLevelString);
		
		AssetType assetType = AssetType.valueOf(assetTypeString);
		
		Asset asset = JPA.em().find(Asset.class, assetId);
		
		asset.setInventoryNumber(inventoryNumber);
		asset.setName(name);
		asset.setDescription(description);
		asset.setPurchaseDate(purchaseDate);
		asset.setPriorityLevel(priorityLevel);
		asset.setAssetType(assetType);
		
		return ok();
	}
	
	@Transactional
	public Result newAsset() throws ParseException{
		DynamicForm requestData = Form.form().bindFromRequest();
		String inventoryNumber = requestData.get("inventoryNumber");
		String name = requestData.get("name");
		String description = requestData.get("description");
		String purchaseDateString = requestData.get("purchaseDate");
		String priorityLevelString = requestData.get("priorityLevel");
		String assetTypeString = requestData.get("assetType");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date purchaseDate = formatter.parse(purchaseDateString);
		
		Integer priorityLevel = Integer.parseInt(priorityLevelString);
		
		AssetType assetType = AssetType.valueOf(assetTypeString);
		
		Asset asset = new Asset();
		
		asset.setInventoryNumber(inventoryNumber);
		asset.setName(name);
		asset.setDescription(description);
		asset.setPurchaseDate(purchaseDate);
		asset.setPriorityLevel(priorityLevel);
		asset.setAssetType(assetType);
		
		JPA.em().persist(asset);
		return ok();
	}
	
	@Transactional
	public Result deleteAsset(Long assetId) throws ParseException{

		return ok();
	}
	

}
