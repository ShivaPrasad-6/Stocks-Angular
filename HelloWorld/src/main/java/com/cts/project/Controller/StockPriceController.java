package com.cts.project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dao.StockPriceRepository;
import com.cts.project.pojos.StockPrice;



@RestController
@RequestMapping("/getAllStockPrice")
public class StockPriceController {
	
	@Autowired
	private StockPriceRepository stockpriceRepository;
	
	@GetMapping
	public Iterable<StockPrice> getAllStockPrice(){
		return stockpriceRepository.findAll();
	}
	
	@PostMapping("/saveStockPrice")
	public  StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	
	@PutMapping("/updateStockPrice/{companyname}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice,@PathVariable("companyname") String companyname) {
		stockprice.setCompanynamef(companyname);
		System.out.println(stockprice);
		
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	@DeleteMapping("/deleteStockPrice/{companyname}")
	public Boolean deleteStockPrice(@PathVariable("companyname") String companyname) {
		System.out.println(companyname);
		stockpriceRepository.deleteById(companyname);
		return true;
	}

	@GetMapping("/findOneInAll5/{companyname}")
	public StockPrice findoneinall(@PathVariable("companyname") String companyname) {
		Optional<StockPrice> stockprice = stockpriceRepository.findById(companyname);
		return stockprice.get();
	}
	
}