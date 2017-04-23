package com.diligentia;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DownloadPage {

    public static final String HTTP_URL = "https://www.endomondo.com/challenges/32422477";
    public static final String HTTP_URL_SESSION = "http://www.endomondo.com/rest/session";

    @PostConstruct
	public void startBean() {

		try {
			conectAndGetSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dowloadAndParse(HTTP_URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		for (int i = 0; i < 10; i++) {
//			try {
//				dowloadAndParse(HTTP_URL);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

	}

    private void conectAndGetSession() throws IOException {

        //This will get you the response.
//        Connection.Response res = Jsoup
//                .connect("https://www.endomondo.com/rest/session")
////                .data("{email: \"radoslaw.wichrowski@gmail.com\", password: \"pass\", remember: true}")
//                .data("email", "radoslaw.wichrowski@gmail.com")
//                .data("password", "pass")
//                .data("remember", "true")
////				.userAgent("Mozilla")
//                .method(Connection.Method.POST)
//                .execute();


		Document doc = Jsoup.connect("https://www.endomondo.com/rest/session")
				.data("email", "radoslaw.wichrowski@gmail.com")
				.data("pass", "pass")
				.data("remember", "true")
// and other hidden fields which are being passed in post request.
				.userAgent("Mozilla")
				.post();
		System.out.println(doc); // will print html source of homepage of facebook.
//		// Document doc = Jsoup.connect("http://www.facebook.com")
//				.data("email", "radoslaw.wichrowski@gmail.com")
//				.data("pass", "pass")
//// and other hidden fields which are being passed in post request.
//				.userAgent("Mozilla")
//				.post();
//		System.out.println(doc); // will print html source of homepage of facebook.


//This will get you cookies
//        Map<String, String> cookies = res.cookies();
//
////And this is the easieste way I've found to remain in session
//        Document doc = Jsoup.connect(HTTP_URL).cookies(cookies).get();
//
//		System.err.println(doc.body().text());
//		new HtmlParser().parse(doc);

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