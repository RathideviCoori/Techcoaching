package com.ebill.service;

import com.ebill.dto.ElectricityBill;

public class EBillCalculator {

	private int unitOfConsumption = 0;
	private Double energyCharges = 0.0;
	private Double fcaCharges = 0.0;
	private Double dutyCharges =0.0;
	private ElectricityBill electrictyBill;
	
	public int getUnitOfConsumption() {
		return unitOfConsumption;
	}

	public ElectricityBill getElectrictyBill() {
		return electrictyBill;
	}


	public void setElectrictyBill(ElectricityBill electrictyBill) {
		this.electrictyBill = electrictyBill;
	}


	public void setUnitOfConsumption(int unitOfConsumption) {
		this.unitOfConsumption = unitOfConsumption;
	}
	
	public Double getEnergyCharges() {
		return energyCharges;
	}


	public Double getDutyCharges() {
		return dutyCharges;
	}


	public void setDutyCharges(int unitOfConsumption) {
		this.dutyCharges = calculateDutyCharges(unitOfConsumption);
	}


	public Double getFcaCharges() {
		return fcaCharges;
	}


	public void setFcaCharges(int unitOfConsumption) {
		this.fcaCharges = calculateFcaCharges(unitOfConsumption);
	}


	public void setEnergyCharges(int unitOfConsumption) {
		this.energyCharges = calculateEnergyCharges(unitOfConsumption);
	}


	public Double calculateEnergyCharges(int unitOfConsumption) {
		Double energyCharges = 0.0;
		if(unitOfConsumption>0 && unitOfConsumption<=50) {
			//C (Charges) = A (Unit Bifurcation) x B (Rate) - 4.05 for slab 1 up to 50.
			energyCharges = unitOfConsumption*4.05;
		}else if(unitOfConsumption>50 && unitOfConsumption<=150){
			int unitBifurcation = (unitOfConsumption-50);
			energyCharges = 50*4.05+unitBifurcation*4.95;
		}
		return energyCharges;
	}


	public Double calculateFcaCharges(int unitOfConsumption) {
		Double fcaCharges = 0.0;
		if(unitOfConsumption>0) {
			//E = A (units) * 0.13 i.e. 13 paisa per unit
			fcaCharges = unitOfConsumption*0.13;
		}
		
		return fcaCharges;
	}


	public Double calculateDutyCharges(int unitOfConsumption) {
		Double dutyCharges = 0.0;
		if(unitOfConsumption>0) {
			//Total Duty Charges (I)  = Slab Wise Duty (G) + FCA on Duty (H) 
			Double slabwiseDutyCharges = calculateSlabwiseDutyCharges(unitOfConsumption);
			Double fcaOnDuty = calculateFcaOnDuty(slabwiseDutyCharges);
			dutyCharges = slabwiseDutyCharges+fcaOnDuty;
		}
		return dutyCharges;
	}


	public Double calculateSlabwiseDutyCharges(int unitOfConsumption) {
		Double slabwiseDutyCharges = 0.0;
		if(unitOfConsumption>0 && unitOfConsumption<=50) {
			//Slab Wise Duty (G)  =Unit of consumption * F|| F is duty charge which is 0.09 for slab 1 (up to 50)
			slabwiseDutyCharges = unitOfConsumption*0.09;
		}else if(unitOfConsumption>50 && unitOfConsumption<=150){
			int unitBifurcation = (unitOfConsumption-50);
			slabwiseDutyCharges = 50*0.09+unitBifurcation*0.12;
		}
		return slabwiseDutyCharges;
	}


	public Double calculateFcaOnDuty(Double slabwiseDutyCharges) {
		Double fcaOnDuty = 0.0;
		if(slabwiseDutyCharges>0) {
			 //FCA on Duty (H) : H = slabwiseDuty charge * 0.13 
			fcaOnDuty = slabwiseDutyCharges*0.13;
		}
		return fcaOnDuty;
	}


	public void calculateElectrictyBill() {
		electrictyBill = new ElectricityBill();
		if(getUnitOfConsumption()>0) {
			setDutyCharges(getUnitOfConsumption());
			setEnergyCharges(getUnitOfConsumption());
			setFcaCharges(getUnitOfConsumption());
			electrictyBill.setDutyCharges(getDutyCharges());
			electrictyBill.setEnergyCharges(getEnergyCharges());
			electrictyBill.setFcaCharges(getFcaCharges());
			electrictyBill.setElectricityBill(getEnergyCharges()+getFcaCharges()+getDutyCharges());
			setElectrictyBill(electrictyBill);
		}
		
	}
   
	
    
}
