package com.diligentia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

//Tutorial https://jsoup.org/cookbook/extracting-data/attributes-text-html
@Component
public class HtmlParser {

	public List<Member> enucleateMembersFromHtml(String html) {
        Document doc = Jsoup.parse(html);
        return parseDocs(doc);
	}

    private List<Member> parseDocs(Document doc) {

        Elements ranking = doc.select("div.chart-row");

        List<Member> personList = new ArrayList<>();
        for (int i = 0; i < ranking.size(); i++) {
            Element element = ranking.get(i);
            personList.add(parseMember(element));
        }
        return personList;
    }

	private Member parseMember(Element element) {
		String name = element.select("a.name").first().text();
		String score = element.select("div.nose").first().text();
        if (!score.contains("km")) {
            return new Member(name, BigDecimal.ZERO);
        }
        score = score.substring(0, score.indexOf("km") - 1);
        return new Member(name, new BigDecimal(score));

	}


}
