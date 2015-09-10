package com.lombax.worker;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import com.lombax.Social;
import com.lombax.panel.TwitterPanel;
import com.lombax.panel.TwitterPanel.Display;
import com.lombax.twitter.Storage;

public class TwitterLoginURLWorker extends SwingWorker<String, String>{

	@Override
	protected String doInBackground() throws Exception {
		
		Storage.requestToken = Social.twitter.getOAuthRequestToken();
		String url = Storage.requestToken.getAuthorizationURL();
		System.out.println("Open the following URL and grant access to your account:");
		System.out.println(url);
		System.out.print("Enter the PIN(if available) or just hit enter.[PIN]:");
		TwitterPanel.panelToRender(Display.LOGIN_PAGE, Social.window.getTwitPanel());
	    return url;  
	}
	
	@Override
	protected void done(){
		String url;
		try {
			url = get();
			if(Desktop.isDesktopSupported())
			{
				Desktop.getDesktop().browse(new URI(url));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
