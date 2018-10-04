package com.test.service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.test.model.InstructionInfo;


public class TradeServiceImpl implements ITradeService {

	@Override
	public List<InstructionInfo> getDailyTrades() {
		//mocked the data for demo
		return getMockData();
	}

	@Override
	public List<InstructionInfo> updateSettlementDate(List<InstructionInfo> tradeData) {
		return tradeData.stream().map(trade -> {

			if (!(trade.getCurrency().equals("AED") || trade.getCurrency().equals("SAR"))) {

				InstructionInfo info = (InstructionInfo)trade.clone();

				if (trade.getOrigSettlementDate().getDayOfWeek() == DayOfWeek.SATURDAY) {
					info.setNewSettlementDate(trade.getOrigSettlementDate().plusDays(2));
				}
				else if (trade.getOrigSettlementDate().getDayOfWeek() == DayOfWeek.SUNDAY) {
					info.setNewSettlementDate(trade.getOrigSettlementDate().plusDays(1));
				}
				else {
					info.setNewSettlementDate(trade.getOrigSettlementDate());
				}

				return info;

			}
			else {

				InstructionInfo info = (InstructionInfo)trade.clone();

				if (trade.getOrigSettlementDate().getDayOfWeek() == DayOfWeek.FRIDAY) {
					info.setNewSettlementDate(trade.getOrigSettlementDate().plusDays(2));
				}
				else if (trade.getOrigSettlementDate().getDayOfWeek() == DayOfWeek.SATURDAY) {
					info.setNewSettlementDate(trade.getOrigSettlementDate().plusDays(1));
				}
				else {
					info.setNewSettlementDate(trade.getOrigSettlementDate());
				}

				return info;
			}
		}).collect(Collectors.toList());
	}

	private static List<InstructionInfo> getMockData() {
		List<InstructionInfo> instructionInfo = new ArrayList<>();
		InstructionInfo info = new InstructionInfo();
		info.setEntity("foo_dup");
		info.setBuySellFlag('B');
		info.setAgreedFx(0.50);
		info.setCurrency("SGP");
		info.setInstructionDate(LocalDate.of(2018, 9, 28));
		info.setOrigSettlementDate(LocalDate.of(2018, 9, 29));
		info.setUnits(201);
		info.setPricePerUnit(100.25);
		instructionInfo.add(info);
		
		info = new InstructionInfo();
		info.setEntity("foo");
		info.setBuySellFlag('B');
		info.setAgreedFx(0.50);
		info.setCurrency("SGP");
		info.setInstructionDate(LocalDate.of(2018, 9, 25));
		info.setOrigSettlementDate(LocalDate.of(2018, 9, 30));
		info.setUnits(201);
		info.setPricePerUnit(100.25);
		instructionInfo.add(info);

		info = new InstructionInfo();
		info.setEntity("foo_1");
		info.setBuySellFlag('B');
		info.setAgreedFx(0.50);
		info.setCurrency("SGP");
		info.setInstructionDate(LocalDate.of(2018, 10, 1));
		info.setOrigSettlementDate(LocalDate.of(2018, 10, 4));
		info.setUnits(212);
		info.setPricePerUnit(100.25);
		instructionInfo.add(info);

		info = new InstructionInfo();
		info.setEntity("foo_Largest");
		info.setBuySellFlag('B');
		info.setAgreedFx(0.50);
		info.setCurrency("SGP");
		info.setInstructionDate(LocalDate.of(2018, 10, 1));
		info.setOrigSettlementDate(LocalDate.of(2018, 10, 5));
		info.setUnits(300);
		info.setPricePerUnit(100.25);
		instructionInfo.add(info);

		info = new InstructionInfo();
		info.setEntity("bar_large");
		info.setBuySellFlag('S');
		info.setAgreedFx(0.22);
		info.setCurrency("AED");
		info.setInstructionDate(LocalDate.of(2018, 10, 5));
		info.setOrigSettlementDate(LocalDate.of(2018, 10, 6));
		info.setUnits(450);
		info.setPricePerUnit(150.5);
		instructionInfo.add(info);
		
		info = new InstructionInfo();
		info.setEntity("bar_1");
		info.setBuySellFlag('S');
		info.setAgreedFx(0.22);
		info.setCurrency("SAR");
		info.setInstructionDate(LocalDate.of(2018, 10, 3));
		info.setOrigSettlementDate(LocalDate.of(2018, 10, 4));
		info.setUnits(250);
		info.setPricePerUnit(150.5);
		instructionInfo.add(info);

		return instructionInfo;
	}
}
