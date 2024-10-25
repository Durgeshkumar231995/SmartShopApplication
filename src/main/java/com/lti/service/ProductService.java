package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;



@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;

	public List<Product> getallProduct() {
		
		return productDao.findAll();
	}
	
	public Product AddSingleProduct(Product p) {
		
		return productDao.save(p);
		
	}
	
	public List<Product> getProductByName(String pname) {
		return productDao.findAll().stream().filter(p -> p.getPname().equals(pname)).toList();
	}
	
	public Product updateProduct(Integer id)
	{
		 Product product = productDao.findById(id).get();
	     
	        return productDao.save(product);		
	}

	public Product findById(Integer productId) {
		
		return productDao.getById(productId);
	}

	public List<Product> getProductByCategoryName(String category) {
		return productDao.findAll().stream().filter(p -> p.getCategory().equals(category)).toList();
	}



public String deleteByRate() {
		List<Product> allProducts = productDao.findAll();
		int counter = 0;
		for (Product p : allProducts) {
			if (p.getRating() <= 3) {
				counter++;
				productDao.deleteById(p.getProductId());
			}
		}
		String message =  "This product is deleted from catalog"+counter;
		return message;
	}



public String  getTotalPrice() {
	List<Product> allProducts = productDao.findAll();
	for (Product p : allProducts) {
		p.setTotalPrice(p.getQuantity() * p.getUnitPrice());
		productDao.save(p);
	}	
	
	String message =" Products Updated"+allProducts.size();
	return message;
}
	
	

}
