package com.example.rael.service;

import java.util.HashMap;
import java.util.List;

import com.example.rael.dto.ProductAllSelectDTO;
import com.example.rael.dto.ProductDTO;
import com.example.rael.dto.ProductDetailDTO;
import com.example.rael.dto.SearchDTO;
import com.example.rael.paging.PagingResponse;

public interface ProductService {
	// Select All Product
	int AllCount(SearchDTO searchDTO);
	PagingResponse<ProductAllSelectDTO> SelectAllProduct(SearchDTO searchDTO);
	
	// (ComboBOX) Select Category's nums
	List<String> SelectCategoryNums();
	String SelectProductNumSEQ(HashMap<String,Integer> categoryMap);
	
	// (ReadOnly) Select Product Detail By Num
	int SelectProductDetailLastByNumber(HashMap<String,Object> productdata);
	
	// Insert Product&ProductDetail 
	int InsertProduct(ProductDTO productDTO);
	int InsertProductDetail(String ProductNum, int ProductByNum, ProductDetailDTO productDetailDTO);
	
	// Update Product&ProductDetail
	int UpdateProduct(String ProductNum, String ProductName);
	int UpdateProductDetail(String ProductNum, int ProductByNum, ProductDetailDTO productDetailDTO);
	
	// (ComboBOX) Check Modified Data Before Update
	int ProductCount(int CategoryNum);
	List<String> SelectProductNames(int CategoryNum);
	PagingResponse<ProductDTO> SelectProduct(SearchDTO searchDTO, int CategoryNum);
	ProductDTO SelectProductROW(String ProductNum);
	
	int ProductDetailCount(int CategoryNum);
	PagingResponse<ProductAllSelectDTO> SelectProductDetail(SearchDTO searchDTO, int CategoryNum);
	
	ProductAllSelectDTO SelectProductDetailROW(HashMap<String, Object> productdata);
	
	int ProductStockPrice(String stockstate, String stocknum);
	
}
