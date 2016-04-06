package util;

import java.util.List;

import persistence.Asset;
import play.db.jpa.JPA;

public class CheckoutDAO {

	public static List<Asset> getCheckedOutAssets(){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null";
		return JPA.em().createQuery(query, Asset.class).getResultList();
	}
	public static List<Asset> getOverdueAssets(){
		String query = "select a from CheckoutEvent ce join ce.lineItems li join li.asset a where li.dateCheckedIn is null";
		return JPA.em().createQuery(query, Asset.class).getResultList();
	}
}
