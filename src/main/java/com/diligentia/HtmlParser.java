package com.diligentia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public void parse(String html) {
//        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(html);
        Elements ranking = doc.select("div.y-axis-area");

        for (int i = 0; i < ranking.size(); i++) {
            Element element = ranking.get(i);
            parseMember(element);
        }

        String text = doc.body().text(); // "An example link"
        String linkHref = ranking.attr("href"); // "http://example.com/"
        String linkText = ranking.text(); // "example""

        String linkOuterH = ranking.outerHtml();
        // "<a href="http://example.com"><b>example</b></a>"
        String linkInnerH = ranking.html(); // "<b>example</b>"
    }

    private void parseMember(Element element) {
        System.err.println(element.select("a.name").first());

    }

    public static void main(String[] args) {
//        new HtmlParser().parse(response);
    }
}
