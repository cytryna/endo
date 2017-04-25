package com.diligentia;

import com.diligentia.model.SessionLoginRequest;
import com.google.gson.Gson;
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
		Gson gson = new Gson();
		Connection.Response res = Jsoup
				.connect(HTTP_URL_HOME)
				.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0")
				.method(Connection.Method.GET)
				.execute();
		Map<String, String> cookies = res.cookies();

		System.err.println(cookies.get("CSRF_TOKEN"));

		SessionLoginRequest sessionLoginRequest = new SessionLoginRequest("radoslaw.wichrowski@gmail.com", "", true);
		//This will get you the response.
		System.err.println(gson.toJson(sessionLoginRequest));
		Document res2 = Jsoup
                .connect(HTTP_URL_SESSION)
				.requestBody(gson.toJson(sessionLoginRequest))
				.header("X-CSRF-TOKEN", cookies.get("CSRF_TOKEN"))
				.header("Content-Type", "application/json;charset=utf-8")
				.header("Accept", "application/json, text/plain, */*")
				.header("Accept-Language", "en-US,en;q=0.5")
				.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0")
//				.proxy("127.0.0.1", 8080)
//				.validateTLSCertificates(false)
				.cookies(cookies)
				.ignoreContentType(true)
                .post();

		Map<String, String> cookies2 = res.cookies();
		System.out.println(cookies2);
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