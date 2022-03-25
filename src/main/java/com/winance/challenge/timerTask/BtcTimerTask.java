package com.winance.challenge.timerTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.winance.challenge.models.BtcStateTimestamp;

@Service
public class BtcTimerTask extends TimerTask {

	private List<BtcStateTimestamp> list = new ArrayList<BtcStateTimestamp>();
	private Timer timer;
	
	public BtcTimerTask() {
		timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, 10000);
		System.out.println("Timer Start");
	}
	
	public List<BtcStateTimestamp> getList() {
		return list;
	}
	
	@Override
	public void run() {
		String URL="https://cex.io/api/last_price/BTC/USD";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		
		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		list.add(getModel(response));
		System.out.println("Tamaño: "+list.size());
		
		System.out.println(response);
		
	}
	
	private BtcStateTimestamp getModel(String response) {
		BtcStateTimestamp item = new BtcStateTimestamp();
		
		JSONObject object = new JSONObject(response);
		item.setLprice(object.getDouble("lprice"));
		item.setCurr1(object.getString("curr1"));
		item.setCurr2(object.getString("curr2"));
		return item;
	}
}
