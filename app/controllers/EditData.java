package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import datadefinitions.AssetType;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

public class EditData extends Controller{
	
	@Transactional
	public Result editAsset(Long assetId) throws ParseException{
		DynamicForm requestData = Form.form().bindFromRequest();
		String inventoryNumber = requestData.get("inventoryNumber");
		String name = requestData.get("name");
		String description = requestData.get("description");
		String purchaseDateString = requestData.get("purchaseDate");
		String priorityLevelString = requestData.get("priorityLevel");
		String highProfileString = requestData.get("highProfile");
		String assetTypeString = requestData.get("assetType");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date purchaseDate = formatter.parse(purchaseDateString);
		
		Integer priorityLevel = Integer.parseInt(priorityLevelString);
		
		Boolean highProfile = Boolean.parseBoolean(highProfileString);
		AssetType assetType = AssetType.valueOf(assetTypeString);
		
		
		return ok();
	}
	
	@Transactional
	public Result deleteAsset(Long assetId) throws ParseException{

		return ok();
	}
	
	@Transactional
	public Result newAsset() throws ParseException{

		return ok();
	}

}
