package com.diligentia;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@Component
public class DownloadPage {

    public static final String HTTP_URL_HOME = "https://www.endomondo.com/home";
    public static final String HTTP_URL_SESSION = "https://www.endomondo.com/rest/session";
    public static final String HTTP_URL_CHALLENGE = "https://www.endomondo.com/challenges/32422477";

    @PostConstruct
	public void startBean() {

		try {
			conectAndGetSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dowloadAndParse(HTTP_URL_CHALLENGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		for (int i = 0; i < 10; i++) {
//			try {
//				dowloadAndParse(HTTP_URL_CHALLENGES);
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

		Connection.Response res = Jsoup
				.connect(HTTP_URL_HOME)
				.method(Connection.Method.GET)
//				.userAgent("Mozilla")
				.execute();
		Map<String, String> cookies = res.cookies();

		System.err.println(cookies.get("CSRF_TOKEN"));

		//This will get you the response.
		Connection.Response  res2 = Jsoup
                .connect(HTTP_URL_SESSION)
                .data("email", "radoslaw.wichrowski@gmail.com")
                .data("password", "")
                .data("remember", "true")
				.cookies(cookies)
                .method(Connection.Method.POST)
                .execute();
//
//		System.err.println("dddddddddddddddddd");
//		Map<String, String> cookies2 = res.cookies();


//		Document doc = Jsoup.connect("https://www.endomondo.com/rest/session")
//				.data("email", "radoslaw.wichrowski@gmail.com")
//				.data("pass", "qwerty")
//				.data("remember", "true")
//				.cookies(cookies)
//// and other hidden fields which are being passed in post request.
//				.userAgent("Mozilla")
//				.post();
//		System.out.println(doc);

		// will print html source of homepage of facebook.
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
//        Document doc = Jsoup.connect(HTTP_URL_CHALLENGES).cookies(cookies).get();
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