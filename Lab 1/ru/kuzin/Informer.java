package ru.kuzin;
import java.util.Date;

public class Informer{
	int count;
	
	public Informer(){
		this.count = 0;
	}
	
	public String getCurrentDate(){
		Date date = new Date();
		this.count++;
		return "Current date: " + date.toString();
	}
	
	public String getCurrentDirectory(){
		this.count++;
		return "Current directory: " + System.getProperty("user.dir");
	}
	
	public String getUsageNumber(){
		return "You used this informer " + Integer.toString(this.count) + " times";
	}
}