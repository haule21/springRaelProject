package com.example.rael.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rael.dto.ProductAllSelectDTO;
import com.example.rael.dto.ProductDTO;
import com.example.rael.dto.ProductDetailDTO;
import com.example.rael.dto.SearchDTO;
import com.example.rael.mapper.ProductMapper;
import com.example.rael.paging.Pagination;
import com.example.rael.paging.PagingResponse;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper productMapper;
	
	public int AllCount(SearchDTO searchDTO) {
		return productMapper.AllCount(searchDTO);
	}
	
	public PagingResponse<ProductAllSelectDTO> SelectAllProduct(SearchDTO searchDTO){
		int count = productMapper.AllCount(searchDTO);
		Pagination pagination = new Pagination(count, searchDTO);
		searchDTO.setPagination(pagination);
        List<ProductAllSelectDTO> list = productMapper.SelectAllProduct(searchDTO);
		return new PagingResponse<>(list, pagination);
	}
	
	public List<String> SelectCategoryNums(){
		return productMapper.SelectCategoryNums();
	}
	
	public String SelectProductNumSEQ(HashMap<String,Integer> categoryMap) {
		return productMapper.SelectProductNumSEQ(categoryMap);
	}
	
	// (ReadOnly) Select Product Detail By Num
	public int SelectProductDetailLastByNumber(HashMap<String,Object> productdata) {
		return productMapper.SelectProductDetailLastByNumber(productdata);
	}
	
	
	// Insert Product&ProductDetail
	public int InsertProduct(ProductDTO productDTO) {;
		return productMapper.InsertProduct(productDTO); 
	}
	public int InsertProductDetail(String ProductNum, int ProductByNum, ProductDetailDTO productDetailDTO) {
		return productMapper.InsertProductDetail(ProductNum ,ProductByNum, productDetailDTO);
	}
	
	// Update Product&ProductDetail
	public int UpdateProduct(String ProductNum, String ProductName) {
		return productMapper.UpdateProduct(ProductNum, ProductName); 
	}
	
	public int UpdateProductDetail(String ProductNum, int ProductByNum, ProductDetailDTO productDetailDTO) {
		return productMapper.UpdateProductDetail(ProductNum, ProductByNum, productDetailDTO);
	}
	
	
	// (ComboBOX) Check Modified Data Before Update
	public int ProductCount(int CategoryNum) {
		return productMapper.ProductCount(CategoryNum);
	}
	public List<String> SelectProductNames(int CategoryNum){
		return productMapper.SelectProductNames(CategoryNum);
	}
	
	public PagingResponse<ProductDTO> SelectProduct(SearchDTO searchDTO, int CategoryNum){
		int count = productMapper.ProductCount(CategoryNum);
		Pagination pagination = new Pagination(count, searchDTO);
		searchDTO.setPagination(pagination);
        List<ProductDTO> list = productMapper.SelectProduct(searchDTO, CategoryNum);
        
        return new PagingResponse<>(list, pagination);
	}
	public ProductDTO SelectProductROW(String ProductNum) {
		return productMapper.SelectProductROW(ProductNum);
	}
	public int ProductDetailCount(int CategoryNum) {
		return productMapper.ProductDetailCount(CategoryNum);
	}
	public PagingResponse<ProductAllSelectDTO> SelectProductDetail(SearchDTO searchDTO, int CategoryNum){
		int count = productMapper.ProductDetailCount(CategoryNum);
		Pagination pagination = new Pagination(count, searchDTO);
		searchDTO.setPagination(pagination);
        List<ProductAllSelectDTO> list = productMapper.SelectProductDetail(searchDTO, CategoryNum);
        
        return new PagingResponse<>(list, pagination);
	}
	public ProductAllSelectDTO SelectProductDetailROW(HashMap<String, Object> productdata) {
		return productMapper.SelectProductDetailROW(productdata);
	}
	
	public int ProductStockPrice(String stockstate, String stocknum) {
		return productMapper.ProductStockPrice(stockstate, stocknum);
	}
}
