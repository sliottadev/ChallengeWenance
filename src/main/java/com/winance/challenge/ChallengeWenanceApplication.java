package com.winance.challenge;

import java.util.List;
import java.util.Timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.winance.challenge.models.BtcStateTimestamp;
import com.winance.challenge.timerTask.BtcTimerTask;

@SpringBootApplication
public class ChallengeWenanceApplication {
	
	public static List<BtcStateTimestamp> btcStateList;

	public static void main(String[] args) {
		
//		Timer timer = new Timer();
//		
//		BtcTimerTask btcTimerTask = new BtcTimerTask();
//		
//		timer.scheduleAtFixedRate(btcTimerTask, 0, 10000);
		
		SpringApplication.run(ChallengeWenanceApplication.class, args);
	}

}
