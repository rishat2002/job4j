package ru.job4j.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseSqlRu implements Parse{
    @Override
    public List<Vacancy> list (String link)  {
        List<Vacancy> list=new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elementForTag = doc.getElementsByClass("postslisttopic");
            for (Element elem : elementForTag) {
                if ((elem.text().matches(".*Java.*")) && (!(elem.text().matches(".*JavaScript.*")
                        || elem.text().matches(".*Java Script.*")))) {
                    Elements e = elem.getElementsByTag("a");
                    Document d = null;
                    try {
                        d = Jsoup.connect(e.attr("href")).get();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Elements forText = d.getElementsByTag("meta");
                    for (Element n : forText) {
                        if (n.attr("name").equals("Description")) {
                            list.add(new Vacancy(elem.text(), e.attr("href"), n.attr("content")));
                        }
                    }
                }
            }
        return list;
    }

    @Override
    public Vacancy detail(String link) throws IOException {
        Document doc = Jsoup.connect(link).get();
        String vacancyText;
        String vacancyName;
        String vacancyLink;
        Elements elementForTag = doc.getElementsByClass("msgBody");
        vacancyText=elementForTag.text();
        Element elForName=doc.tagName("font");
        vacancyName=elForName.text().substring(0,elForName.text().indexOf("/"));
        vacancyLink=link;
        return new Vacancy(vacancyName,vacancyLink,vacancyText);
    }

    public static void main(String[] args) throws IOException {


    }
}
