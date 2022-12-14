package com.example.rael.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rael.dto.SearchDTO;
import com.example.rael.dto.StockHistoryDTO;
import com.example.rael.dto.StockSelectDTO;

@Mapper
public interface StockMapper {
	
	int StockCount(SearchDTO searchDTO);
	int StockHistoryCount(SearchDTO searchDTO);
	List<StockSelectDTO> SelectStock(SearchDTO searchDTO);
	List<StockHistoryDTO> SelectStockHistory(SearchDTO searchDTO);
	int StockHistoryInsert(StockHistoryDTO stockHistoryDTO);
	int StockHistoryCancel(int stockseq);

}
