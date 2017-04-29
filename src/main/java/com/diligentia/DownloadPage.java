package com.diligentia;

import com.diligentia.entity.Book;
import com.diligentia.model.SessionLoginRequest;
import com.diligentia.service.BookService;
import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class DownloadPage {

    public static final String HTTP_URL_HOME = "https://www.endomondo.com/home";
    public static final String HTTP_URL_SESSION = "https://www.endomondo.com/rest/session";
    public static final String HTTP_URL_CHALLENGE = "https://www.endomondo.com/challenges";
    private SessionLoginRequest sessionLoginRequest;
    private Map<String, String> cookiesSession;
    private Map<String, String> cookiesHome;

    @Inject
    private BookService bService;

    @PostConstruct
    public void startBean() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        sessionLoginRequest = new SessionLoginRequest("radoslaw.wichrowski@gmail.com", prop.get("password").toString(), true);

        conectAndGetSession();
        dowloadAndParseChallenge(prop.get("challenge").toString());

//        List<Book> allBooks = bService.getAllBooks();
//        for (int i = 0; i < allBooks.size() ; i++) {
//            System.err.println(allBooks.get(i).getTitle());
//         }

    }

    private void conectAndGetSession() throws IOException {
        Gson gson = new Gson();
        Connection.Response res = Jsoup
                .connect(HTTP_URL_HOME)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0")
                .method(Connection.Method.GET)
                .execute();
        cookiesHome = res.cookies();

        Connection.Response res2 = Jsoup
                .connect(HTTP_URL_SESSION)
                .requestBody(gson.toJson(sessionLoginRequest))
                .header("X-CSRF-TOKEN", cookiesHome.get("CSRF_TOKEN"))
                .header("Content-Type", "application/json;charset=utf-8")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-US,en;q=0.5")
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0")
                .cookies(cookiesHome)
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                .execute();
        cookiesSession = res2.cookies();

    }

    public void dowloadAndParseChallenge(String challengeId) throws IOException {
        Connection.Response res3 = Jsoup
                .connect(HTTP_URL_CHALLENGE + "/" + challengeId)
                .header("X-CSRF-TOKEN", cookiesHome.get("CSRF_TOKEN"))
                .header("Content-Type", "application/json;charset=utf-8")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "en-US,en;q=0.5")
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:53.0) Gecko/20100101 Firefox/53.0")
                .cookies(cookiesSession)
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();

        new HtmlParser().parse(res3.body().toString());
    }
}