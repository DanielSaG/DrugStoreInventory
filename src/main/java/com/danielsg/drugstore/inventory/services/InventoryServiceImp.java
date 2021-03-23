/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.services;

import com.danielsg.drugstore.inventory.dao.ProductPackageDao;
import com.danielsg.drugstore.inventory.dto.ProductPackageRequest;
import com.danielsg.drugstore.inventory.dto.ProductPackageResponse;
import com.danielsg.drugstore.inventory.entities.ProductPackage;
import com.danielsg.drugstore.inventory.mappers.ProductPackageRequestMapper;
import com.danielsg.drugstore.inventory.mappers.ProductPackageResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danie
 */
@Service
public class InventoryServiceImp implements InventoryService{
    
    @Autowired
    ProductPackageDao ppDao;
    @Autowired
    ProductPackageRequestMapper reqMapper;
    @Autowired
    ProductPackageResponseMapper respMapper;

    @Override
    @Transactional
    public long createProductPackage(ProductPackageRequest req) {
        ProductPackage pp=reqMapper.ProductPackageRequestToProductPackage(req);
        pp=ppDao.save(pp);
        return pp.getPackageId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPackageResponse> retrieveAllProductPackages() {
        return respMapper.ProductPackageListToProductPackageResponseList(ppDao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductPackageResponse retrieveProductPackageById(long id) {
        return respMapper.ProductPackageToProductPackageResponse(ppDao.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void updateProductPackage(long id, ProductPackageRequest req) {
        ProductPackage pp=reqMapper.ProductPackageRequestToProductPackage(req);
        pp.setPackageId(id);
        ppDao.save(pp);
    }

    @Override
    @Transactional
    public void updateProductPackagePartial(long id, ProductPackageRequest req) {
        ProductPackage pp=ppDao.findById(id).orElse(null);
        pp.merge(reqMapper.ProductPackageRequestToProductPackage(req));
        ppDao.save(pp);
    }

    @Override
    @Transactional
    public void deleteProdcutPackage(long id) {
        ProductPackage pp=new ProductPackage();
        pp.setPackageId(id);
        ppDao.delete(pp);
    }
    
}
