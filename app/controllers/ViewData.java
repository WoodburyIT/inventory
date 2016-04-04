package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import persistence.Asset;
import persistence.Customer;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.SessionHandler;

public class ViewData extends Controller {

	@Transactional
	public Result viewCart() {
		Set<Long> assetIds = SessionHandler.setFromCookie(session().get("assetsInCart"));
		Long customerId = SessionHandler.singleFromCookie(session().get("customerInCart"));
		System.out.println("assetIds : " + assetIds);
		System.out.println("customerId : " + customerId);
		return ok();
	}
	@Transactional
    public Result viewCustomer(long customerId) {
		Customer customer = JPA.em().find(Customer.class, customerId);
        return ok(Json.toJson(customer)); 
    }
	
	@Transactional
    public Result viewAsset(long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
        return ok(Json.toJson(asset)); 
    }
	
	@Transactional
    public Result getCustomer(long customerId) {
		Customer customer = JPA.em().find(Customer.class, customerId);
        return ok(Json.toJson(customer)); 
    }
	
	@Transactional
    public Result getAsset(long assetId) {
		Asset asset = JPA.em().find(Asset.class, assetId);
        return ok(Json.toJson(asset)); 
    }
	
	@Transactional
    public Result byInventoryNum(String invNum) {
		System.out.println("invNum : " + invNum);
		String query = "from Asset a where a.inventoryNumber = :invNum";
		Query q = JPA.em().createQuery(query, Asset.class);
		q.setParameter("invNum", invNum);
		List<Asset> results = q.getResultList();
		if(results.size() > 1){
			return ok(Json.toJson(results.get(0)));
		}
		return ok(Json.toJson("{}"));
    }
	
	@Transactional
    public Result assetList(int count, int offset, int priority, String search) {
		String query;
		Query q;
		System.out.println("priority : " + priority);
		if(search == null) {
			query = "from Asset a where a.priorityLevel >= :priority";
			q = JPA.em().createQuery(query);
		}
		else {
			query = "from Asset a where a.priorityLevel >= :priority and (a.description like '%:search%' or a.name like '%:search%')";
			q = JPA.em().createQuery(query);
			q.setParameter("search", search);
		}
		q.setParameter("priority", priority);
		List<Asset> assets = q.setMaxResults(count).setFirstResult(offset).getResultList();
        return ok(Json.toJson(assets)); 
    }
}