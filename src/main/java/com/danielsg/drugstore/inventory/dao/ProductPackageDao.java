/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.dao;

import com.danielsg.drugstore.inventory.entities.ProductPackage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danie
 */

public interface ProductPackageDao extends JpaRepository<ProductPackage, Long>{
    
}
