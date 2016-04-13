package util;

import java.util.List;

import persistence.Asset;
import persistence.CheckoutEvent;
import persistence.ScheduledCheckout;
import play.db.jpa.JPA;

public class CheckoutDAO {
	

	public static List<Asset> getCheckedOutAssets(){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null";
		return JPA.em().createQuery(query, Asset.class).getResultList();
	}
	public static List<Asset> getImportantCheckedOutAssets(){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null and a.priorityLevel <=3";
		return JPA.em().createQuery(query, Asset.class).getResultList();
	}
	public static List<Asset> getOverdueAssets(){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn > CURRENT_TIMESTAMP";
		return JPA.em().createQuery(query, Asset.class).getResultList();
	}
	public static List<CheckoutEvent> getCurrentCheckoutEvents(){
		String query = "select ce from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null";
		return JPA.em().createQuery(query, CheckoutEvent.class).getResultList();
	}
	public static List<CheckoutEvent> getAllCheckoutEvents(int count, int offset){
		String query = "select ce from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null";
		return JPA.em().createQuery(query, CheckoutEvent.class).setMaxResults(count).setFirstResult(offset).getResultList();
	}
	public static List<ScheduledCheckout> getScheduledCheckouts(){
		String query = "select sc from ScheduledCheckout sc";
		return JPA.em().createQuery(query, ScheduledCheckout.class).getResultList();
	}
	
	public boolean isCheckedOut(Long assetId){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null and a.assetId = :assetId";
		Asset asset = JPA.em().createQuery(query, Asset.class).getSingleResult();
		if(asset != null){
			return true;
		}
		return false;
	}
}
