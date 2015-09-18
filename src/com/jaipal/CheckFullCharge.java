package com.jaipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javazoom.jlgui.basicplayer.BasicPlayerException; 

    public class CheckFullCharge 
    { 
       public static void main(String args[])  
        { 
        	
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable periodicTask = new Runnable() {
        	public void run() {
        	    int charge=getCharge();
                if(charge==100 || charge <=15){
                    	String text=null;
                    	if(charge==100) text="Charge is Full"; else text="Charge is Low:";
                        new TranslucencyDemo(text);
                        try {
							new playit().play();
						} catch (BasicPlayerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                              
                    }
        	    }
        	};
        	executor.scheduleAtFixedRate(periodicTask, 0,20, TimeUnit.SECONDS);
        	
        } 
        
       private static int  getCharge(){
        		int charge=0;
        		try 
                 { 
                 	
                     Process p=Runtime.getRuntime().exec("WMIC Path Win32_Battery Get EstimatedChargeRemaining"); 
                     p.waitFor(); 
                     BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
                     String line; 
                     while((line = reader.readLine()) != null) 
                     { 
                        
                        if(line.trim().equalsIgnoreCase("estimatedchargeremaining")){
                     	   reader.readLine(); 
                     	   charge=Integer.parseInt(reader.readLine().trim());
                      }
                     } 

                 }
                 catch(IOException e1) {} 
                 catch(InterruptedException e2) {} 
        	return charge;
        }
    }
