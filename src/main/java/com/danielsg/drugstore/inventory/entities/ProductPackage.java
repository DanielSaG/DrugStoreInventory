/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@Entity(name = "inventory")
public class ProductPackage implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="package_id")
    private long packageId;
    @Column(name="product_id")
    private long productId;
    @Column(name="location_id")
    private long locationId;
    private int quantity;
    
    public void merge(ProductPackage pp){
        productId=pp.getProductId()>0?pp.getProductId():productId;
        locationId=pp.getLocationId()>0?pp.getLocationId():locationId;
        quantity=pp.getQuantity()>0?pp.getQuantity():quantity;
    }
}
