package com.ebill.dto;

public class ElectricityBill {
	
	private Double energyCharges;
	private Double fcaCharges;
	private Double dutyCharges;
	
	private Double electricityBill=0.0;

	/**
	 * @return the energyCharges
	 */
	public Double getEnergyCharges() {
		return energyCharges;
	}

	/**
	 * @return the fcaCharges
	 */
	public Double getFcaCharges() {
		return fcaCharges;
	}

	/**
	 * @param energyCharges the energyCharges to set
	 */
	public void setEnergyCharges(Double energyCharges) {
		this.energyCharges = energyCharges;
	}

	/**
	 * @param fcaCharges the fcaCharges to set
	 */
	public void setFcaCharges(Double fcaCharges) {
		this.fcaCharges = fcaCharges;
	}

	/**
	 * @param dutyCharges the dutyCharges to set
	 */
	public void setDutyCharges(Double dutyCharges) {
		this.dutyCharges = dutyCharges;
	}

	/**
	 * @param electricityBill the electricityBill to set
	 */
	public void setElectricityBill(Double electricityBill) {
		this.electricityBill = electricityBill;
	}

	/**
	 * @return the dutyCharges
	 */
	public Double getDutyCharges() {
		return dutyCharges;
	}

	/**
	 * @return the electricityBill
	 */
	public Double getElectricityBill() {
		return electricityBill;
	}

	

}
