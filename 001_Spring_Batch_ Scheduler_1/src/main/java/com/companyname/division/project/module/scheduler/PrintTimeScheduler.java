package com.companyname.division.project.module.scheduler;

import java.time.LocalTime;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTimeScheduler {

	@Scheduled(fixedDelay=5000)
	public void printTime() {
		System.out.println(" Get lucky Number at "+LocalTime.now() +" is :-" +getRandomNumber());
	}	
	
	private int getRandomNumber() {		
		Random random = new Random();
		return random.nextInt(100);		
	}
}
