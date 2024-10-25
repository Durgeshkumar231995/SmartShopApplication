package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productId;
	String pname;
	String Category;
	Integer quantity;
	float unitPrice;
	float totalPrice;
	Integer rating;
	public Product() {
		super();
		
	}
	public Product(Integer productId, String pname, String category, Integer quantity, float unitPrice,
			float totalPrice, Integer rating) {
		super();
		this.productId = productId;
		this.pname = pname;
		Category = category;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.rating = rating;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", pname=" + pname + ", Category=" + Category + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", rating=" + rating + "]";
	}
	

	
	
	
	
	
	
	
}
