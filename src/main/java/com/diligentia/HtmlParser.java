package com.diligentia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
//        String text = doc.body().text(); // "An example link"
//        String linkHref = ranking.attr("href"); // "http://example.com/"
//        String linkText = ranking.text(); // "example""
//
//        String linkOuterH = ranking.outerHtml();
//        // "<a href="http://example.com"><b>example</b></a>"
//        String linkInnerH = ranking.html(); // "<b>example</b>"

public class HtmlParser {

    public void parse(Document doc) {

        Elements ranking = doc.select("div.chart-row");

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < ranking.size(); i++) {
            Element element = ranking.get(i);
            personList.add(parseMember(element));
        }
    }

	public void parse(String html) {
        Document doc = Jsoup.parse(html);
        parse(doc);
	}

	private Person parseMember(Element element) {
		String name = element.select("a.name").first().text();
		String score = element.select("div.nose").first().text();
        if (!score.contains("km")) {
            return new Person(name, BigDecimal.ZERO);
        }
        score = score.substring(0, score.indexOf("km") - 1);
        return new Person(name, new BigDecimal(score));

	}


}
