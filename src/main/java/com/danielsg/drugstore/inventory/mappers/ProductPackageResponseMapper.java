/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.mappers;

import com.danielsg.drugstore.inventory.dto.ProductPackageResponse;
import com.danielsg.drugstore.inventory.entities.ProductPackage;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author danie
 */
@Mapper(componentModel = "spring")
public interface ProductPackageResponseMapper {
    ProductPackage ProductPackageResponseToProductPackage(ProductPackageResponse source);
    List<ProductPackage> ProductPackageResponseListToProductPackageList(List<ProductPackageResponse> source);
    
    ProductPackageResponse ProductPackageToProductPackageResponse(ProductPackage source);
    List<ProductPackageResponse> ProductPackageListToProductPackageResponseList(List<ProductPackage> source);
}
