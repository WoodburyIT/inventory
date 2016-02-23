package controllers;

import java.util.Calendar;

import datadefinitions.AssetType;
import persistence.Asset;
import persistence.TestEntity;
import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	@Transactional
    public Result index() {
		Asset asset = new Asset();
		asset.setName("New Laptop");
		asset.setAssetType(AssetType.LAPTOP);
		asset.setPriorityLevel(8);
		asset.setPurchaseDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		asset.setDescription("This asset probably has something complicated about it that needs describing");
		JPA.em().persist(asset);
        return ok(views.html.index.render("Your new application is ready.")); 
    }
	
	public Result newAssetForm() {
		
		return ok();
	}

}
