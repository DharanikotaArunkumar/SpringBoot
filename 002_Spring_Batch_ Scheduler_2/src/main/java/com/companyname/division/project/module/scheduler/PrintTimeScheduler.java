package com.companyname.division.project.module.scheduler;

import java.time.LocalTime;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTimeScheduler {

	//@Scheduled(fixedDelay=1000)
	public void printTime() {
		System.out.println(" Get lucky Number at "+LocalTime.now() +" is :-" +getRandomNumber());
	}
	
	//@Scheduled(initialDelay=5000,fixedDelay=1000)
	public void printTimeWithInitialDelay() {
		System.out.println(" Get lucky Number at  started after 5 seconds "+LocalTime.now() +" is :-" +getRandomNumber());
	}
	
	
	//@Scheduled(initialDelayString="5000",fixedDelayString="1000")
	public void printTimeWithInitialDelayString() {
		System.out.println(" Get lucky Number at  started after 5 seconds "+LocalTime.now() +" is :-" +getRandomNumber());
	}	
	
	
@Scheduled(cron= "0 * * * * MON-SAT")
	public void printTimeWithCronPattern() {
		System.out.println(" Printing Random Number Using Cron Pattern  "+LocalTime.now() +" is :-" +getRandomNumber());
	}
	
	/*
	 * Format :- <Minute> <Hour> <Day_of_the_Month> <Month_of_the_Year> <Day_of_the_Week> <Year>
	 * 
					* * * * * *
					| | | | | | 
					| | | | | +-- Year              (range: 1900-3000)
					| | | | +---- Day of the Week   (range: 1-7, 1 standing for Monday)
					| | | +------ Month of the Year (range: 1-12)
					| | +-------- Day of the Month  (range: 1-31)
					| +---------- Hour              (range: 0-23)
					+------------ Minute            (range: 0-59)
					
					
					*  Denotes the each min .each second,each year based on position
					
					* * * * * * *                         Each minute

					59 23 31 12 5 *                     One minute  before the end of year if the last day of the year is Friday
									
					59 23 31 DEC Fri *                  Same as above (different notation)

					45 17 7 6 * *                       Every  year, on June 7th at 17:45
					
		Refer More :- http://www.nncron.ru/help/EN/working/cron-format.htm
	 */
	
	
	//@Scheduled(cron= "0 * * * * MON-SAT",zone="IST")
	public void printTimeWithCronPatternAndZone() {
		System.out.println(" Printing Random Number Using Cron Pattern with IST Time  "+LocalTime.now() +" is :-" +getRandomNumber());
	}
	
	private int getRandomNumber() {		
		Random random = new Random();
		return random.nextInt(100);		
	}
}
