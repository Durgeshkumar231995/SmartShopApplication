package com.lti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Product;
import com.lti.exception.ItemNotFoundException;
import com.lti.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Product Service", description = "Provided by Lti Developers")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;

	@ApiOperation(value = "Get All Product")
	@GetMapping("/AllProduct")
	public List<Product> getAllProduct() {
		logger.info("Get all product");

		return productService.getallProduct();

	}

	// localhost:8084/AddProduct
	/*
	 * {
	 * 
	 * "pname": "Accer", "category": "Laptop", "quantity": 31, "unitPrice":
	 * 52520.23, "totalPrice": 43330.22, "rating": 3
	 * 
	 * }
	 * 
	 */
	@ApiOperation(value = "Add Single Product")
	@PostMapping("/AddProduct")
	public Product AddProduct(@RequestBody Product product) {
		logger.info("add single product");
		return productService.AddSingleProduct(product);

	}

//localhost:8084/updateProduct/3
	@ApiOperation(value = "Update  Product by id")

	@PutMapping("/updateProductId/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable(value = "id") Integer productId,
			@RequestBody Product productDetails) throws ItemNotFoundException {

		logger.info("update product by proving id  ");

		Product product = productService.findById(productId);

		// .orElseThrow(() ->
		// new ItemNotFoundException("Product not found for this id :: " +
		// productId));

		product.setPname(productDetails.getPname());
		product.setCategory(productDetails.getCategory());
		product.setQuantity(productDetails.getQuantity());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setTotalPrice(productDetails.getTotalPrice());
		product.setRating(productDetails.getRating());

		Product updateSingleProduct = productService.AddSingleProduct(product);

		return ResponseEntity.ok(updateSingleProduct);
	}
	// localhost:8084/getProductByName/Accer

	@GetMapping("/getProductByName/{pname}")
	public List<Product> getProductbyName(@PathVariable(value = "pname") String pname) {
		logger.info("Search product by name");
		return productService.getProductByName(pname);
	}

	// localhost:8084/getProductByCategoryName/mobile
	@ApiOperation(value = "Get Product by category")
	@GetMapping("/getProductByCategoryName/{category}")
	public List<Product> getProductByCategoryName(@PathVariable(value = "category") String category) {
		logger.info("get product by category");
		return productService.getProductByCategoryName(category);
	}

	@ApiOperation(value = "detele by rating less than 2 ")
	@DeleteMapping("/deletebyrate")
	public String deletebyRating() {
		logger.info("delete by rating less than  ");
		return productService.deleteByRate();
	}

	@ApiOperation(value = "Get Total Price")
	@PutMapping("/totalPrice")
	public String calTotalPrice() {
		logger.info("Get Total Price ");
		return productService.getTotalPrice();
	}

}
