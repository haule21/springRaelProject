package com.example.rael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.rael.dto.SearchDTO;
import com.example.rael.dto.StockHistoryDTO;
import com.example.rael.dto.StockSelectDTO;
import com.example.rael.paging.PagingResponse;
import com.example.rael.service.ProductService;
import com.example.rael.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/stock_select")
	public ModelAndView Stock_Select(	@ModelAttribute("param") SearchDTO param,
										@RequestParam(value = "categoryBox", required=false, defaultValue="defaultValue") String category) {
		ModelAndView mv = new ModelAndView();
		List<String> categorydata = productService.SelectCategoryNums();
		mv.addObject("categorynums", categorydata);
		
		
		if(category.equals("defaultValue")) {
		}
		else {
			String[] temp_categorydatas = category.split("/", 2);
			int temp_categorynum = Integer.parseInt(temp_categorydatas[0]);
			
			param.setCategorynum(temp_categorynum);
		}
		mv.addObject("categoryBox", category);
		PagingResponse<StockSelectDTO> datas = stockService.SelectStock(param);
		mv.addObject("datas", datas);
		SearchDTO searchDTO = new SearchDTO(); 
		
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		mv.setViewName("stock/stock_select");
		return mv;
	}
	
	@RequestMapping("/stock_history")
	public ModelAndView Stock_History(	@ModelAttribute("param") SearchDTO param,
										@RequestParam(value="categoryBox" , required=false, defaultValue="defaultValue") String selected) {
		ModelAndView mv = new ModelAndView();
		
		if(selected.equals("defaultValue")) {
			
		}
		else {
			String[] a = selected.split("/",2);
			
			param.setCategorynum(Integer.parseInt(a[0]));
		}
		
		PagingResponse<StockHistoryDTO> datas = stockService.SelectStockHistory(param);
		List<String> categorynums = productService.SelectCategoryNums();
		
		SearchDTO searchDTO = new SearchDTO(); 
		
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		
		mv.addObject("categorynums", categorynums);
		mv.addObject("datas", datas);
		mv.setViewName("stock/stock_history");
		return mv;
	}
	@RequestMapping("/stock_history_cancel")
	public ModelAndView Stock_History_Cancel(	@ModelAttribute("param") SearchDTO param,
												@RequestParam(value="categoryBox" , required=false, defaultValue="defaultValue") String selected) {
		ModelAndView mv = new ModelAndView();
		
		if(selected.equals("defaultValue")) {
		}
		else {
			String[] a = selected.split("/",2);
			
			param.setCategorynum(Integer.parseInt(a[0]));
		}
		
		
		PagingResponse<StockHistoryDTO> datas = stockService.SelectStockHistory(param);
		List<String> categorynums = productService.SelectCategoryNums();
		
		SearchDTO searchDTO = new SearchDTO(); 
		
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		mv.addObject("categorynums", categorynums);
		mv.addObject("datas", datas);
		mv.setViewName("stock/stock_history_cancel");
		return mv;
	}
	@RequestMapping(value="/stock_history/CANCEL/{id}", method = RequestMethod.POST)
	public ModelAndView Stock_CANCEL(	@PathVariable("id") int seq,
										RedirectAttributes rs) {
		ModelAndView mv = new ModelAndView();
		
		int result = stockService.StockHistoryCancel(seq);
		
		rs.addFlashAttribute("insertresult", result == 1 ? 1 : 0);
		mv.setViewName("redirect:/stock/stock_history");
		return mv;
	}
	
	@RequestMapping("/stock_in/{stockstate}/{stocknum}/{stockname}")
	public ModelAndView Stock_In(	@PathVariable("stockstate") String stockstate,
									@PathVariable("stocknum") String stocknum,
									@PathVariable("stockname") String stockname) {
		ModelAndView mv = new ModelAndView();
		
		int price = productService.ProductStockPrice(stockstate, stocknum);
		List<String> categorynums = productService.SelectCategoryNums();
		SearchDTO searchDTO = new SearchDTO();
		
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		mv.addObject("categorynums", categorynums);
		mv.addObject("stocknum", stocknum);
		mv.addObject("stockname", stockname);
		mv.addObject("stockprice", price);
		mv.setViewName("/stock/stock_in");
		
		return mv;
	}
	
	@RequestMapping(value="/stock_in/INSERT", method = RequestMethod.POST)
	public ModelAndView Stock_In_INSERT(	@RequestParam("stock state") String stockstate,
											@RequestParam("stock num") String stocknum,
											@RequestParam("stock quantity") int stockquantity,
											@RequestParam("stock price") int stockprice,
											RedirectAttributes re) {
		ModelAndView mv = new ModelAndView();
		
		StockHistoryDTO data = new StockHistoryDTO();
		
		data.setSTOCKSTATE(stockstate);
		data.setSTOCKNUM(stocknum);
		data.setSTOCKQUANTITY(stockquantity);
		data.setSTOCKPRICE(stockprice);
		data.setSTOCKPRICESUM(stockprice*stockquantity);
		
		int result = stockService.StockHistoryInsert(data);
		re.addFlashAttribute("insertresult", result == 1 ? 1 : 0);
		SearchDTO searchDTO = new SearchDTO();
		
		re.addAttribute("page",searchDTO.getPage());
		re.addAttribute("pageSize",searchDTO.getPageSize());
		re.addAttribute("recordSize",searchDTO.getRecordSize());
		
		mv.setViewName("redirect:/stock/stock_select");
		return mv;
	}
	@RequestMapping("/stock_out/{stockstate}/{stocknum}/{stockname}")
	public ModelAndView Stock_Out(	@PathVariable("stockstate") String stockstate,
									@PathVariable("stocknum") String stocknum,
									@PathVariable("stockname") String stockname) {
		ModelAndView mv = new ModelAndView();
		
		int price = productService.ProductStockPrice(stockstate, stocknum);
		List<String> categorynums = productService.SelectCategoryNums();
		SearchDTO searchDTO = new SearchDTO(); 
		
		mv.addObject("page",searchDTO.getPage());
		mv.addObject("pageSize",searchDTO.getPageSize());
		mv.addObject("recordSize",searchDTO.getRecordSize());
		mv.addObject("categorynums", categorynums);
		mv.addObject("stocknum", stocknum);
		mv.addObject("stockname", stockname);
		mv.addObject("stockprice", price);
		mv.setViewName("/stock/stock_out");
		
		return mv;
	}
	@RequestMapping(value="/stock_out/INSERT", method = RequestMethod.POST)
	public ModelAndView Stock_Out_INSERT(	@RequestParam("stock state") String stockstate,
											@RequestParam("stock num") String stocknum,
											@RequestParam("stock quantity") int stockquantity,
											@RequestParam("stock price") int stockprice,
											RedirectAttributes re) {
		ModelAndView mv = new ModelAndView();
		StockHistoryDTO data = new StockHistoryDTO();
		
		data.setSTOCKSTATE(stockstate);
		data.setSTOCKNUM(stocknum);
		data.setSTOCKQUANTITY(stockquantity);
		data.setSTOCKPRICE(stockprice);
		data.setSTOCKPRICESUM(stockprice*stockquantity);
		
		int result = stockService.StockHistoryInsert(data);
		re.addFlashAttribute("insertresult", result == 1 ? 1 : 0);
		SearchDTO searchDTO = new SearchDTO();
		
		re.addAttribute("page",searchDTO.getPage());
		re.addAttribute("pageSize",searchDTO.getPageSize());
		re.addAttribute("recordSize",searchDTO.getRecordSize());
		
		mv.setViewName("redirect:/stock/stock_select");
		return mv;
	}
	
	
}
