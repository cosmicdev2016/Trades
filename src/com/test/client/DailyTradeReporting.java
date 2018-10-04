package com.test.client;


import java.util.List;

import com.test.model.InstructionInfo;
import com.test.service.ReportServiceImpl;
import com.test.service.TradeServiceImpl;


/**
 * Client to run the report demo
 * 
 * @author Gaurav
 *
 */
public class DailyTradeReporting {

	public static void main(String[] args) {

		TradeServiceImpl tradeService = new TradeServiceImpl();

		//Get the daily trades data
		//this is a mock data for demo
		List<InstructionInfo> instructionInfo = tradeService.getDailyTrades();

		//calculate and update the settlement date based on entity (AED or SAR)
		instructionInfo = tradeService.updateSettlementDate(instructionInfo);

		//Generate the Text report and display on Console
		ReportServiceImpl reportService = new ReportServiceImpl();
		reportService.generateTextReport(instructionInfo);

	}

}

