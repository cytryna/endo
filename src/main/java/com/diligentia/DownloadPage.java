package com.diligentia;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class DownloadPage {

    @PostConstruct
	public void startBean() {

		for (int i = 0; i < 10; i++) {
			try {
				dowloadAndParse("https://www.endomondo.com/challenges/32706833");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void dowloadAndParse(String urlStr) throws IOException {

		// Make a URL to the web page
		URL url = new URL(urlStr);

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String response = new String();
		for (String line; (line = br.readLine()) != null; response += line)
			;

		new HtmlParser().parse(response);
	}
}