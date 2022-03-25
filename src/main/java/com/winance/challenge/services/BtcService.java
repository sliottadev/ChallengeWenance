package com.winance.challenge.services;

import java.util.Date;
import java.util.List;

import com.winance.challenge.dtos.BtcTimestampSummary;
import com.winance.challenge.models.BtcStateTimestamp;

public interface BtcService {
	public List<BtcStateTimestamp> getList();
	public List<String> getTimeStamps();
	public BtcStateTimestamp getStateByTimestamp(String date);
	public Double getAverangeByTimestamp(String date1, String date2);
	public Double getPercentByTimestamp(String date1, String date2);
	public Double getMaxPrice();
	public BtcTimestampSummary getSummaryByTimestamp(String date1, String date2);
}
