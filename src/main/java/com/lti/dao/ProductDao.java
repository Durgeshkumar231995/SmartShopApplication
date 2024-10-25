package com.lti.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product, Integer> {

}
