package com.winance.challenge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BtcControllerHome {
	
	public final String HOME= "index";
	public final String BTC_TIMESTAMP= "BtcByTimeStamp";
	public final String BTC_COMPARE_TIMESTAMP= "BtcCompareTimestamp";

	@RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World!");
        return HOME;
    }

	@RequestMapping("/BtcByTimeStamp")
    public String BtcByTimeStamp(Model model) {
        model.addAttribute("message", "Hello World!");
        return BTC_TIMESTAMP;
    }

	@RequestMapping("/BtcCompareTimestamp")
    public String BtcCompareTimestamp(Model model) {
        model.addAttribute("message", "Hello World!");
        return BTC_COMPARE_TIMESTAMP;
    }
	
}
