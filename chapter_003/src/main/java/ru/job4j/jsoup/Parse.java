package ru.job4j.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    public List<Vacancy> ParsePage() throws IOException {
        List<Vacancy> list=new ArrayList<>();
        for (int i=1;i<6;i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job/"+Integer.valueOf(i)).get();
            Elements elementForTag = doc.getElementsByClass("postslisttopic");
            for (Element elem : elementForTag) {
                if ((elem.text().matches(".*Java.*")) && (!(elem.text().matches(".*JavaScript.*")
                        || elem.text().matches(".*Java Script.*")))) {
                    Elements e = elem.getElementsByTag("a");
                    Document d = Jsoup.connect(e.attr("href")).get();
                    Elements forText = d.getElementsByTag("meta");
                    for (Element n : forText) {
                        if (n.attr("name").equals("Description")) {
                            list.add(new Vacancy(elem.text(), e.attr("href"), n.attr("content")));
                        }
                    }

                }
            }
        }
        return list;
    }
    public static void main(String[] args) throws IOException {

    }
}
