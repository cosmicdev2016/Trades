package com.test.model;


import java.time.LocalDate;


public class InstructionInfo {

	private String entity;
	private char buySellFlag;
	private double agreedFx;
	private String currency;
	private LocalDate instructionDate;
	private LocalDate origSettlementDate;
	private int units;
	private double pricePerUnit;

	//calculated fields
	private LocalDate newSettlementDate;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public char getBuySellFlag() {
		return buySellFlag;
	}

	public void setBuySellFlag(char buySellFlag) {
		this.buySellFlag = buySellFlag;
	}

	public double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getOrigSettlementDate() {
		return origSettlementDate;
	}

	public void setOrigSettlementDate(LocalDate origSettlementDate) {
		this.origSettlementDate = origSettlementDate;
	}

	public LocalDate getNewSettlementDate() {
		return newSettlementDate;
	}

	public void setNewSettlementDate(LocalDate newSettlementDate) {
		this.newSettlementDate = newSettlementDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getSettleAmount() {
		return this.getPricePerUnit() * this.getUnits() * this.getAgreedFx();
	}

	@Override
	public String toString() {
		return "InstructionInfo{" + "entity='" + entity + '\'' + ", buySellFlag=" + buySellFlag + ", agreedFx="
			+ agreedFx + ", currency='" + currency + '\'' + ", instructionDate=" + instructionDate
			+ ", origSettlementDate=" + origSettlementDate + ", newSettlementDate=" + newSettlementDate + ", units="
			+ units + ", pricePerUnit=" + pricePerUnit + '}';
	}

	@Override
	public Object clone() {
		try {
			return (InstructionInfo)super.clone();
		}
		catch (CloneNotSupportedException e) {
			InstructionInfo info = new InstructionInfo();
			info.setEntity(this.getEntity());
			info.setBuySellFlag(this.getBuySellFlag());
			info.setAgreedFx(this.getAgreedFx());
			info.setCurrency(this.getCurrency());
			info.setInstructionDate(this.getInstructionDate());
			info.setOrigSettlementDate(this.getOrigSettlementDate());
			info.setUnits(this.getUnits());
			info.setPricePerUnit(this.getPricePerUnit());
			return info;
		}
	}
}
