package com.jaipal;
import java.io.File;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class playit {
 
	public static void main(String args[]) throws BasicPlayerException, InterruptedException {
		new playit().play();
	}	
public void play() throws BasicPlayerException, InterruptedException{
	BasicPlayer bp=new BasicPlayer();
	bp.open(new File("music.mp3"));
	bp.play();
	Thread.sleep(10000);
	}
    
    
}
