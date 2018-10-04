package com.test.service;


import java.util.List;

import com.test.model.InstructionInfo;


public interface IReportService {

	/**
	 * Generate the text report from trades
	 * 
	 * @param tradeData
	 */
	public void generateTextReport(List<InstructionInfo> tradeData);
}
