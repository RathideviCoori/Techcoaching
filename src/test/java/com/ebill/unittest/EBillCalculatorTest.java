package com.ebill.unittest;

import static org.junit.Assert.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import com.ebill.dto.ElectricityBill;
import com.ebill.service.EBillCalculator;


public class EBillCalculatorTest {
	
	public  EBillCalculator ebillCalculator;
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit = 0
	 * Application calculate Energy Charges as {double}
	 */
	@Test
	public void shouldReturnEnergyChargeAsZeroWhenthereisnoUnitOfConsumption() {
		int unitOfConsumption = 0;
		ebillCalculator = new EBillCalculator();
		Double energyCharges = ebillCalculator.calculateEnergyCharges(unitOfConsumption );
		assertEquals(new Double(0), energyCharges);
		
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit <=50
	 * Application calculate Energy Charges as {double}
	 */
	@Test
	public void shouldReturnEnergyChargesWhenUnitOfConsumtionUnderSlabOne() {
		int unitOfConsumption = 50;
		ebillCalculator = new EBillCalculator();
		Double energyCharges = ebillCalculator.calculateEnergyCharges(unitOfConsumption );
		assertEquals(new Double(202.50), energyCharges);
		unitOfConsumption = 45;
		ebillCalculator = new EBillCalculator();
		energyCharges = ebillCalculator.calculateEnergyCharges(unitOfConsumption );
		assertEquals(new Double(182.25), energyCharges,0.01);
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit = 0
	 * Application calculate FCA Charges as {double}
	 */
	@Test
	public void shouldReturnFCAChargesAsZeroWhenthereisnoUnitOfConsumption() {
		int unitOfConsumption = 0;
		ebillCalculator = new EBillCalculator();
		Double fcacharges = ebillCalculator.calculateFcaCharges(unitOfConsumption );
		assertEquals(new Double(0), fcacharges);
		
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit<=0 50
	 * Application calculate FCA Charges as {double}
	 */
	@Test
	public void shouldReturnFCAChargesWhenUnitOfConsumtionUnderSlabOne() {
		int unitOfConsumption = 50;
		ebillCalculator = new EBillCalculator();
		Double fcacharges = ebillCalculator.calculateFcaCharges(unitOfConsumption );
		assertEquals(new Double(6.5), fcacharges);
		unitOfConsumption = 45;
		ebillCalculator = new EBillCalculator();
		fcacharges = ebillCalculator.calculateFcaCharges(unitOfConsumption );
		assertEquals(new Double(5.85), fcacharges,0.01);
		
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit<=0
	 * Application calculate Duty Charges as {double}
	 */
	@Test
	public void shouldReturDutyChargesAsZeroWhenthereisnoUnitOfConsumption() {
		int unitOfConsumption = 0;
		ebillCalculator = new EBillCalculator();
		Double dutyCharges = ebillCalculator.calculateDutyCharges(unitOfConsumption );
		assertEquals(new Double(0), dutyCharges);
	}
	
	/**
	 * Calculate Slabwise Duty charge
	 * return 0 when unitof consumption is zero
	 */
	@Test
	public void shouldReturSlabWiseDutyChargesAsZeroWhenthereisnoUnitOfConsumtionUnderSlabOne() {
		int unitOfConsumption = 0;
		ebillCalculator = new EBillCalculator();
		Double slabwiseDutyCharges = ebillCalculator.calculateSlabwiseDutyCharges(unitOfConsumption );
		assertEquals(new Double(0), slabwiseDutyCharges);
	}
	
	/**
	 * Calculate Slabwise Duty charge for slab 1 (up to 50 unit)
	 */
	@Test
	public void shouldReturSlabWiseDutyChargesWhenUnitOfConsumtionUnderSlabOne() {
		int unitOfConsumption = 50;
		ebillCalculator = new EBillCalculator();
		Double slabwiseDutyCharges = ebillCalculator.calculateSlabwiseDutyCharges(unitOfConsumption );
		assertEquals(new Double(4.5), slabwiseDutyCharges,0.01);
		unitOfConsumption = 45;
		ebillCalculator = new EBillCalculator();
		slabwiseDutyCharges = ebillCalculator.calculateSlabwiseDutyCharges(unitOfConsumption );
		assertEquals(new Double(4.05), slabwiseDutyCharges,0.01);
	}
	
	/**
	 * Calculate Fca on Duty charge
	 * return 0 when slabwiseduty charge is zero
	 */
	@Test
	public void shouldReturFCAOnDutyAsZeroWhenthereisnoUnitOfConsumtionUnderSlabOne() {
		Double slabwiseDutyCharges =0.0;
		ebillCalculator = new EBillCalculator();
		Double fcaOnDuty = ebillCalculator.calculateFcaOnDuty(slabwiseDutyCharges );
		assertEquals(new Double(0), fcaOnDuty);
	}
	
	/**
	 * Calculate Fca on Duty charge for slab one (up to 50 units)
	 */
	@Test
	public void shouldReturFcaOnDutyWhenUnitOfConsumtionUnderSlabOne() {
		Double slabwiseDutyCharges =4.5;
		ebillCalculator = new EBillCalculator();
		Double fcaOnDuty = ebillCalculator.calculateFcaOnDuty(slabwiseDutyCharges);
		assertEquals(new Double(0.585), fcaOnDuty,0.01);
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit>0
	 * Application calculate Duty Charges as {double}
	 */
	@Test
	public void shouldReturDutyChargesWhenUnitOfConsumtionUnderSlabOne() {
		int unitOfConsumption = 50;
		ebillCalculator = new EBillCalculator();
		Double dutyCharges = ebillCalculator.calculateDutyCharges(unitOfConsumption );
		assertEquals(new Double(5.09), dutyCharges,0.01);
		unitOfConsumption = 45;
		ebillCalculator = new EBillCalculator();
		dutyCharges = ebillCalculator.calculateDutyCharges(unitOfConsumption );
		assertEquals(new Double(4.58), dutyCharges,0.01);
		
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit=0
	 * Application calculate ElectrictyBill as 0
	 */
	@Test
	public void shouldReturElectricityBillAsZeroWhenthereisnoUnitOfConsumtion() {
		int unitOfConsumption = 0;
		ebillCalculator = new EBillCalculator();
		ebillCalculator.setUnitOfConsumption(unitOfConsumption);
		ebillCalculator.calculateElectrictyBill();
		assertEquals(new Double(0), ebillCalculator.getElectrictyBill().getElectricityBill(),0.0);
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit>0 Slab one( up to 50 unit)
	 * Application calculate ElectrictyBill as {Double}
	 */
	@Test
	public void shouldReturElectricityBillWhenUnitOfConsumtionForSlabOne() {
		int unitOfConsumption = 50;
		ebillCalculator = new EBillCalculator();
		ebillCalculator.setUnitOfConsumption(unitOfConsumption);
		ebillCalculator.calculateElectrictyBill();
		assertEquals(new Double(214.09), ebillCalculator.getElectrictyBill().getElectricityBill(),0.01);
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit <=50
	 * Application calculate Energy Charges as {double}
	 */
	@Test
	public void shouldReturnEnergyChargesWhenUnitOfConsumtionUnderSlabTwo() {
		int unitOfConsumption = 51;
		ebillCalculator = new EBillCalculator();
		Double energyCharges = ebillCalculator.calculateEnergyCharges(unitOfConsumption );
		assertEquals(new Double(207.45), energyCharges,0.01);
		unitOfConsumption = 150;
		ebillCalculator = new EBillCalculator();
		energyCharges = ebillCalculator.calculateEnergyCharges(unitOfConsumption );
		assertEquals(new Double(697.5), energyCharges,0.01);
	}
	
	@Test
	public void shouldReturnFcaChargesWhenUnitOfConsumtionUnderSlabTwo() {
		int unitOfConsumption = 51;
		ebillCalculator = new EBillCalculator();
		Double fcaCharges = ebillCalculator.calculateFcaCharges(unitOfConsumption ); //No changes done on prod code.
		assertEquals(new Double(6.63), fcaCharges,0.01);
		unitOfConsumption = 150;
		ebillCalculator = new EBillCalculator();
		fcaCharges = ebillCalculator.calculateFcaCharges(unitOfConsumption );
		assertEquals(new Double(19.5), fcaCharges,0.01);
	}
	
	/**
	 * Calculate Slabwise Duty charge for slab two (51 to 150 units)
	 */
	@Test
	public void shouldReturSlabwiseDutyChargesWhenUnitOfConsumtionUnderSlabTwo() {
		int unitOfConsumption = 51;
		ebillCalculator = new EBillCalculator();
		Double slabwiseDutyCharges = ebillCalculator.calculateSlabwiseDutyCharges(unitOfConsumption );
		assertEquals(new Double(4.62), slabwiseDutyCharges,0.01);
		unitOfConsumption = 150;
		ebillCalculator = new EBillCalculator();
		slabwiseDutyCharges = ebillCalculator.calculateSlabwiseDutyCharges(unitOfConsumption );
		assertEquals(new Double(16.5), slabwiseDutyCharges,0.01);
	}

	/**
	 * Calculate Fca on Duty charge for slab two (51 to 150 units)
	 */
	@Test
	public void shouldReturFcaOnDutyWhenUnitOfConsumtionUnderSlabTwo() {
		Double slabwiseDutyCharges =4.62;
		ebillCalculator = new EBillCalculator();
		Double fcaOnDuty = ebillCalculator.calculateFcaOnDuty(slabwiseDutyCharges); //No changes done on prod code
		assertEquals(new Double(0.6006), fcaOnDuty,0.01);
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit>0
	 * Application calculate Duty Charges as {double}
	 */
	@Test
	public void shouldReturDutyChargesWhenUnitOfConsumtionUnderSlabTwo() {
		int unitOfConsumption = 51;
		ebillCalculator = new EBillCalculator();
		Double dutyCharges = ebillCalculator.calculateDutyCharges(unitOfConsumption );
		assertEquals(new Double(5.22), dutyCharges,0.01);
		
	}
	
	/**
	 * "^I enter the unit of consumption as <unit>$" unit>0 Slab one( up to 50 unit)
	 * Application calculate ElectrictyBill as {Double}
	 */
	@Test
	public void shouldReturElectricityBillWhenUnitOfConsumtionForSlabTwo() {
		int unitOfConsumption = 51;
		ebillCalculator = new EBillCalculator();
		ebillCalculator.setUnitOfConsumption(unitOfConsumption);
		ebillCalculator.calculateElectrictyBill();
		//207.45+6.63+5.22 =  No Changes done... 
		assertEquals(new Double(219.3), ebillCalculator.getElectrictyBill().getElectricityBill(),0.01);
	}
}
