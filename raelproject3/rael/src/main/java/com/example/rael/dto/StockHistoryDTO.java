package com.example.rael.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StockHistoryDTO {
	int STOCKSEQUENCE;
	String STOCKNUM;
	String STOCKNAME;
	int STOCKQUANTITY;
	String STOCKSTATE;
	int STOCKPRICE;
	int STOCKPRICESUM;
	Date STOCKAPPENDDATE;
}
