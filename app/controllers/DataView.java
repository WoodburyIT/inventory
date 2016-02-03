package controllers;

import persistence.Asset;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class DataView extends Controller {

	@Transactional
    public Result viewAsset(long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
        return ok(Json.toJson(asset)); 
    }

}