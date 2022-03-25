package com.winance.challenge.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winance.challenge.dtos.BtcTimestampSummary;
import com.winance.challenge.models.BtcStateTimestamp;
import com.winance.challenge.timerTask.BtcTimerTask;

@Service
public class BtcServiceImpl implements BtcService {

	@Autowired
	BtcTimerTask btcTimerTask;
	
	@Override
	public List<BtcStateTimestamp> getList() {
		return btcTimerTask.getList();
	}

	@Override
	public BtcStateTimestamp getStateByTimestamp(String date) {
		System.out.println(date);
		System.out.println("FirstPos:"+btcTimerTask.getList().get(0).getTimestamp()+" - Param:"+date);
		BtcStateTimestamp result = btcTimerTask.getList().stream().filter(item -> item.getTimestamp().equals(date)).findFirst().get();
		return result;
	}

	@Override
	public Double getAverangeByTimestamp(String date1, String date2) {
		List<BtcStateTimestamp> listAux = new ArrayList<BtcStateTimestamp>(btcTimerTask.getList());
		Double result = listAux.stream()
					.filter(item -> compareDateBetweenDates(item.getTimestamp(), date1, date2))
					.mapToDouble(md -> md.getLprice())
					.average()
					.orElse(0);
		return result;
	}

	private boolean compareDateBetweenDates(String timestamp, String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		try {
			final Date timeStpItem = sdf.parse(timestamp);
			final Date timeStp1 = sdf.parse(date1);
			final Date timeStp2 = sdf.parse(date2);
			final boolean result = (timeStpItem.compareTo(timeStp1) >= 0) && (timeStpItem.compareTo(timeStp2)<=0); 
			return result;
		} catch (ParseException e) {
			System.out.println("Error Parsing Date: "+e.getMessage());
			return false;
		}
	}

	@Override
	public Double getPercentByTimestamp(String date1, String date2) {
		Double averange=getAverangeByTimestamp(date1, date2);
		Double max = getMaxPrice();
		return (averange * 100) / max;
	}

	@Override
	public List<String> getTimeStamps() {
		List<String> result = new ArrayList<String>();
		btcTimerTask.getList().forEach(item -> result.add(item.getTimestamp().toString()));
		return result;
	}

	@Override
	public Double getMaxPrice() {
		Double result = btcTimerTask.getList().stream().mapToDouble(md -> md.getLprice()).max().getAsDouble();
		return result;
	}

	@Override
	public BtcTimestampSummary getSummaryByTimestamp(String date1, String date2) {
		BtcTimestampSummary result = new BtcTimestampSummary();
		result.setDate1(date1);
		result.setPrice1(getStateByTimestamp(date1).getLprice());
		result.setDate2(date2);
		result.setPrice2(getStateByTimestamp(date2).getLprice());
		result.setAverange(getAverangeByTimestamp(date1, date2));
		result.setMaxPrice(getMaxPrice());
		result.setPercentWithMax(getPercentByTimestamp(date1, date2));
		return result;
	}


}
