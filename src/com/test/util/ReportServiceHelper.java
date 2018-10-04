package com.test.util;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.test.model.InstructionInfo;

/**
 * Utility class to transform data for reporting purpose
 * 
 * @author Gaurav
 *
 */
public class ReportServiceHelper {
	
	/**
	 * Utility method to get the USD settlement amount incoming or outgoing everyday
	 * 
	 * @param tradeData
	 * @param buySellFlag
	 * @return
	 */
	public static Map<LocalDate, Double> getAmountFlowingEveryday(List<InstructionInfo> tradeData, char buySellFlag) {
		return tradeData.stream()
		.filter(e -> e.getBuySellFlag() == buySellFlag)
		.collect(Collectors.groupingBy(InstructionInfo::getNewSettlementDate,
			Collectors.summingDouble(InstructionInfo::getSettleAmount)));
	}
	
	/**
	 * Utility method to rank the entities based on incoming or outgoing USD settlement amount by entity
	 * 
	 * @param tradeData
	 * @param buySellFlag
	 * @return
	 */
	public static SortedMap<Integer, Set<String>> getRankOfEntities(List<InstructionInfo> tradeData, char buySellFlag) {
		
		SortedMap<Integer, Set<String>> ranking = new TreeMap<>();

		final AtomicInteger rank = new AtomicInteger();
		
		tradeData.stream().filter(e -> e.getBuySellFlag() == buySellFlag)
				.collect(Collectors.groupingBy(InstructionInfo::getSettleAmount,
					() -> new TreeMap<>((c1, c2) -> c2.compareTo(c1)), Collectors.toSet()))
				.entrySet().stream()
				.forEach(e -> ranking.put(rank.incrementAndGet(),
					e.getValue().stream().map(e1 -> e1.getEntity()).collect(Collectors.toSet())));
		
		return ranking;
	}
}