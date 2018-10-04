package com.test.service;


import java.util.List;

import com.test.model.InstructionInfo;


public interface ITradeService {

	/**
	 * Get the trades from the source system
	 * 
	 * @return
	 */
	public List<InstructionInfo> getDailyTrades();

	/**
	 * Update the actual settlement date on each trade based on weekend logic at entity level (AED or SAR)
	 * 
	 * @param tradeData
	 * @return
	 */
	public List<InstructionInfo> updateSettlementDate(List<InstructionInfo> tradeData);
}
