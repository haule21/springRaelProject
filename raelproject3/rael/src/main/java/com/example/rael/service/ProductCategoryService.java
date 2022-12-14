package com.example.rael.service;

import java.util.List;
import java.util.Map;

import com.example.rael.dto.ProductCategoryDTO;
import com.example.rael.dto.SearchDTO;
import com.example.rael.paging.PagingResponse;

public interface ProductCategoryService {
	PagingResponse<ProductCategoryDTO> SelectCategory(SearchDTO param);
	int InsertCategory(ProductCategoryDTO productCategoryDTO);
	int UpdateCategory(ProductCategoryDTO productCategoryDTO);
	int CreateCategorySEQ(Map<String, String> categorynum);
	String SelectForUpdate(int categorynum);
	int Count(SearchDTO searchDTO);
	
	List<String> SelectHeadCategory();
}
