package com.ebill.controller;

import org.springframework.web.bind.annotation.*;

import com.ebill.dto.ElectricityBill;
import com.ebill.service.EBillCalculator;

@RestController
@RequestMapping("/")
public class EBillCalculatorController {
	
	private EBillCalculator ebillCalculator;

	@GetMapping("test")
	public String homepage() {
		return "NewFile";
	}

	@GetMapping("getElectricitybill")
	public ElectricityBill greeting(
			@RequestParam(value = "unitOfConsumption") String consumptionUnit) {
		ebillCalculator = new EBillCalculator();
		ebillCalculator.setUnitOfConsumption(Integer.valueOf(consumptionUnit));
		ebillCalculator.calculateElectrictyBill();
		return ebillCalculator.getElectrictyBill();

	}
}
