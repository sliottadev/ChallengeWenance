package com.winance.challenge.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winance.challenge.dtos.BtcTimestampSummary;
import com.winance.challenge.dtos.TimestampInterval;
import com.winance.challenge.models.BtcStateTimestamp;

@RestController
@RequestMapping("/api")
public class BtcRestController {

	@Autowired
	BtcService btcService;
	
	@GetMapping("/getStateByTimestamp")
	public BtcStateTimestamp getStateByTimestamp(@RequestParam(name="time") String date) {
		BtcStateTimestamp result = btcService.getStateByTimestamp(date);
		return result;
	}
	
//	@GetMapping("/api/getAverangeByTimestamp")
//	public Double getAverangeByTimestamp(@RequestBody TimestampInterval interval) {
//		Double result = btcService.getAverangeByTimestamp(interval.getDate1(), interval.getDate2());
//		return result;
//	}
//
//	@GetMapping("/api/getPercentByTimestamp")
//	public Double getPercentByTimestamp(@RequestBody TimestampInterval interval) {
//		Double result = btcService.getPercentByTimestamp(interval.getDate1(), interval.getDate2());
//		return result;
//	}
	
	@GetMapping("/getTimeStamps")
	public List<String> getTimeStamps() {
		List<String> result = btcService.getTimeStamps();
		return result;
	}
	
	@GetMapping("/getMaxPrice")
	public Double getMaxPrice() {
		Double result = btcService.getMaxPrice();
		return result;
	}
	
	@GetMapping("/getSummaryByTimestamp")
	public BtcTimestampSummary getSummaryByTimestamp(@RequestParam(name="time1")String date1, @RequestParam(name="time2")String date2) {
		BtcTimestampSummary result = btcService.getSummaryByTimestamp(date1, date2);
		return result;
	}
	
}
