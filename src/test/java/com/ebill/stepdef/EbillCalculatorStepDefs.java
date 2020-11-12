package com.ebill.stepdef;

import static org.junit.Assert.assertEquals;

import com.ebill.dto.ElectricityBill;
import com.ebill.service.EBillCalculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EbillCalculatorStepDefs {
	
	private EBillCalculator ebillCalculator;
	
	@Given("I am on the EbillCalculator application")
	public void i_am_on_the_ebill_calculator_application() {
		ebillCalculator = new EBillCalculator();
	}

	@When("I enter the unit of consumption as {int}")
	public void i_enter_the_unit_of_consumption_as(Integer int1) {
		System.out.println("unit of consumption : "+int1);
		ebillCalculator.setUnitOfConsumption(int1);
		
	}

	@Then("Application calculate Energy Charges as {double}")
	public void application_calculate_energy_charges_as(Double expectedVal) {
		System.out.println("Energy charges calculation starts");
		ebillCalculator.setEnergyCharges(ebillCalculator.getUnitOfConsumption());
		Double energyCharges = ebillCalculator.getEnergyCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+energyCharges);
		assertEquals(expectedVal, energyCharges,0.01);
	}


	@Then("Application calculate FCA Charges as {double}")
	public void application_calculate_fca_charges_as(Double expectedVal) {
		System.out.println("FCA charges calculation starts");
		ebillCalculator.setFcaCharges(ebillCalculator.getUnitOfConsumption());
		Double fcaCharges = ebillCalculator.getFcaCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+fcaCharges);
		assertEquals(expectedVal, fcaCharges, 0.01);
	}
	
	@Then("Application calculate Duty Charges as {double}")
	public void application_calculate_duty_charges_as(Double expectedVal) {
		System.out.println("Duty charges calculation starts");
		ebillCalculator.setDutyCharges(ebillCalculator.getUnitOfConsumption());
		Double dutyCharges = ebillCalculator.getDutyCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+dutyCharges);
		assertEquals(expectedVal, dutyCharges, 0.01);
	}
	
	@Then("Application calculate Electricity Bill as {double}")
	public void application_calculate_electricity_bill_as(Double expectedVal) {
		System.out.println("Electricty Bill calculation starts");
		ebillCalculator.calculateElectrictyBill();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+ebillCalculator.getElectrictyBill().getElectricityBill());
		assertEquals(expectedVal, ebillCalculator.getElectrictyBill().getElectricityBill(),0.01);
	}

	@Then("Application calculate Energy Charges as {double} for slab two")
	public void application_calculate_energy_charges_as_for_slab_two(Double expectedVal) {
		System.out.println("Energy charges for slab two calculation starts");
		ebillCalculator.setEnergyCharges(ebillCalculator.getUnitOfConsumption());
		Double energyCharges = ebillCalculator.getEnergyCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+energyCharges);
		assertEquals(expectedVal, energyCharges,0.01);
	}
	
	@Then("Application calculate FCA Charges as {double} for slab two")
	public void application_calculate_fca_charges_as_for_slab_two(Double expectedVal) {
		System.out.println("FCA charges for slab two calculation starts");
		ebillCalculator.setFcaCharges(ebillCalculator.getUnitOfConsumption());
		Double fcaCharges = ebillCalculator.getFcaCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+fcaCharges);
		assertEquals(expectedVal, fcaCharges, 0.01);
	}
	
	@Then("Application calculate Duty Charges as {double} for slab two")
	public void application_calculate_duty_charges_as_for_slab_two(Double expectedVal) {
		System.out.println("Duty charges for slab two calculation starts");
		ebillCalculator.setDutyCharges(ebillCalculator.getUnitOfConsumption());
		Double dutyCharges = ebillCalculator.getDutyCharges();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+dutyCharges);
		assertEquals(expectedVal, dutyCharges, 0.01);
	}
	
	@Then("Application calculate Electricity Bill as {double} for slab two")
	public void application_calculate_electricity_bill_as_for_slab_two(Double expectedVal) {
		System.out.println("Electricty Bill calculation starts");
		ebillCalculator.calculateElectrictyBill();
		System.out.println("Expected : "+expectedVal);
		System.out.println("Actual : "+ebillCalculator.getElectrictyBill().getElectricityBill());
		assertEquals(expectedVal, ebillCalculator.getElectrictyBill().getElectricityBill(),0.01);
	}




}
