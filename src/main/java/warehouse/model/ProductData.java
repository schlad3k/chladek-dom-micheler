package warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductData {
	@Id
	private String productID;
	private String warehouseID;
	private String productName;
	private String productCategory;
	private double productQuantity;

	public ProductData(String warehouseID, String productID, String productName, String productCategory, double productQuantity) {
		this.warehouseID = warehouseID;
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "{" +
				"\"warehouseID\": \"" + warehouseID + "\"," +
				"\"productID\": \"" + productID + "\"," +
				"\"productName\": \"" + productName + "\"," +
				"\"productCategory\": \"" + productCategory + "\"," +
				"\"productQuantity\": " + productQuantity +
				"}";
	}

}
