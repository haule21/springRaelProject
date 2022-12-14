package com.example.rael.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.rael.dto.ProductCategoryDTO;
import com.example.rael.dto.SearchDTO;

@Mapper
public interface ProductCategoryMapper {
	
	List<ProductCategoryDTO> SelectCategory(SearchDTO param);
	int InsertCategory(ProductCategoryDTO productCategoryDTO);
	int CreateCategorySEQ(Map<String, String> categorynum);
	int UpdateCategory(ProductCategoryDTO productCategoryDTO);
	String SelectForUpdate(int categorynum);
	int Count(SearchDTO searchDTO);
	
	List<String> SelectHeadCategory();
	
}
