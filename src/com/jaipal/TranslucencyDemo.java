package com.jaipal;
import java.awt.Color;

import com.nitido.utils.toaster.Toaster;
public class TranslucencyDemo{
	
	
	private String text=null;
	TranslucencyDemo(String show){
		
		text=show;
		notification();
	}
	
	
private  void notification(){
	
	Toaster toasterManager = new Toaster();
    toasterManager.showToaster(text);
    toasterManager.setMessageColor(Color.PINK);
    toasterManager.setDisplayTime(10000);
    toasterManager.setToasterColor(Color.PINK);
    }
}