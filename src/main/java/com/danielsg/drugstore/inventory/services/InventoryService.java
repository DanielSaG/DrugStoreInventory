/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.services;

import com.danielsg.drugstore.inventory.dto.ProductPackageRequest;
import com.danielsg.drugstore.inventory.dto.ProductPackageResponse;
import java.util.List;

/**
 *
 * @author danie
 */
public interface InventoryService {
    public long createProductPackage(ProductPackageRequest req);
    public List<ProductPackageResponse> retrieveAllProductPackages();
    public ProductPackageResponse retrieveProductPackageById(long id);
    public void updateProductPackage(long id, ProductPackageRequest req);
    public void updateProductPackagePartial(long id, ProductPackageRequest req);
    public void deleteProdcutPackage(long id);
}
