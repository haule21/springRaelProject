package com.example.rael.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rael.dto.SearchDTO;
import com.example.rael.dto.StockHistoryDTO;
import com.example.rael.dto.StockSelectDTO;
import com.example.rael.mapper.StockMapper;
import com.example.rael.paging.Pagination;
import com.example.rael.paging.PagingResponse;

@Service
@Transactional
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockMapper stockMapper;
	
	
	public PagingResponse<StockSelectDTO> SelectStock(SearchDTO searchDTO){
		int count = stockMapper.StockCount(searchDTO);
		Pagination pagination = new Pagination(count, searchDTO);
		searchDTO.setPagination(pagination);
        List<StockSelectDTO> list = stockMapper.SelectStock(searchDTO);
		return new PagingResponse<>(list, pagination);
	}
	
	public PagingResponse<StockHistoryDTO> SelectStockHistory(SearchDTO searchDTO){
		int count = stockMapper.StockHistoryCount(searchDTO);
		Pagination pagination = new Pagination(count, searchDTO);
		searchDTO.setPagination(pagination);
        List<StockHistoryDTO> list = stockMapper.SelectStockHistory(searchDTO);
		return new PagingResponse<>(list, pagination);
	}
	
	public int StockHistoryInsert(StockHistoryDTO stockHistoryDTO) {;
		int result = stockMapper.StockHistoryInsert(stockHistoryDTO);
		return result;
	}
	public int StockHistoryCancel(int stockseq) {
		int result = stockMapper.StockHistoryCancel(stockseq);
		return result;
	}
	
}
