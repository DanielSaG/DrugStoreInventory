/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.inventory.controllers;

import com.danielsg.drugstore.inventory.common.APIExcpetionResponse;
import com.danielsg.drugstore.inventory.dto.ProductPackageRequest;
import com.danielsg.drugstore.inventory.dto.ProductPackageResponse;
import com.danielsg.drugstore.inventory.services.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/inventory")
@Api(tags="Inventory API")
public class InventoryController {
    
    private static final String RESOURCE_URI="/inventory/";
    
    @Autowired
    private InventoryService inventoryService;
    
    @ApiOperation(value="Create product package",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=201, message="Product package created", responseHeaders = {
                    @ResponseHeader(
                            name = "Location",
                            description = "The created resource id", 
                            response = String.class)}),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PostMapping()
    public ResponseEntity<?> createProductPackage(@RequestBody ProductPackageRequest ppReq){
        long id=inventoryService.createProductPackage(ppReq);
        return ResponseEntity.created(URI.create(RESOURCE_URI+id)).build();
    }
    @ApiOperation(value="Retrieve all products packages",notes = "Return 204 if no data found",response = ProductPackageResponse.class)
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = ProductPackageResponse.class),
        @ApiResponse(code=204, message="No packages founded"),
        @ApiResponse(code=206, message="Incomplete information"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<ProductPackageResponse>> retrieveAllProductPackage(){
        return ResponseEntity.ok(inventoryService.retrieveAllProductPackages());
    }
    
    @ApiOperation(value="Retrieve product package by id",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = ProductPackageResponse.class),
        @ApiResponse(code=206, message="Incomplete information", response = ProductPackageResponse.class),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=404, message="Drug not found"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @GetMapping("/{packageId}")
    public ResponseEntity<ProductPackageResponse> retrieveProductPackageById(@PathVariable long packageId){
        return ResponseEntity.ok(inventoryService.retrieveProductPackageById(packageId));
    }
    @ApiOperation(value="Update prduct package",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="product package updated"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PutMapping("/{packageId}")
    public ResponseEntity<?> updateProductPackage(@PathVariable long packageId, @RequestBody ProductPackageRequest ppReq){
        inventoryService.updateProductPackage(packageId, ppReq);
        return ResponseEntity.noContent().build();
    }
    @ApiOperation(value="Update product package partial",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Product package updated"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PatchMapping("/{packageId}")
    public ResponseEntity<?> updateProductPackagePartial(@PathVariable long packageId, @RequestBody ProductPackageRequest ppReq){
        inventoryService.updateProductPackagePartial(packageId, ppReq);
        return ResponseEntity.noContent().build();
    }
    @ApiOperation(value="Delete product package",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Product package succesfully deleted"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @DeleteMapping("/{packageId}")
    public ResponseEntity<?> deleteProductPackage(@PathVariable long packageId){
        inventoryService.deleteProdcutPackage(packageId);
        return ResponseEntity.noContent().build();
    }
}
