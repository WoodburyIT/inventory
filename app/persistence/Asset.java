package persistence;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import datadefinitions.AssetType;

@Entity
public class Asset implements Comparable<Asset>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long assetId;
	
	private String inventoryNumber;
	private String name;
	private String description;
	private Date purchaseDate;
	private Integer priorityLevel;
	
	private boolean highProfile;
	private AssetType assetType;

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public boolean isHighProfile() {
		return highProfile;
	}

	public void setHighProfile(boolean highProfile) {
		this.highProfile = highProfile;
	}
	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(Integer priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	@Override
	public int compareTo(Asset o) {
		// compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
		return o.getPriorityLevel().compareTo(this.getPriorityLevel());
	}

}
