/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.mappers;

import com.danielsg.drugstore.inventory.dto.ProductPackageRequest;
import com.danielsg.drugstore.inventory.entities.ProductPackage;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author danie
 */
@Mapper(componentModel = "spring")
public interface ProductPackageRequestMapper {
    
    ProductPackage ProductPackageRequestToProductPackage(ProductPackageRequest source);
    List<ProductPackage> ProductPackageRequestListToProductPackageList(List<ProductPackageRequest> source);
    
    ProductPackageRequest ProductPackageToProductPackageRequest(ProductPackage source);
    List<ProductPackageRequest> ProductPackageListToProductPackageRequestList(List<ProductPackage> source);
    
}
