import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMLParser {


    public String convertHtmlToTxtFile()throws IOException {


        File html = new File("D:/00/9136322092711349487.html");
        // English D:/00/993065305003958.html
        //Arabian D:/00/7659932929301488.html
        //Arabian + English D:/00/710369526417875740.html
        // Undefined D:/00/969511601185894582.html
        // Undefined D:/00/2865901437644396131.html
        //Russian D:/00/5183920012557894167.html
        //Spain D:/00/8157114598290775212.html
        //Ukraine D:/00/8375520248700988162.html
        Document document = Jsoup.parse(html, "UTF-8");
        Elements link = document.select("p");
        StringBuilder stringBuilder = new StringBuilder();

        for(Element elements : link.select("p")){
            stringBuilder.append(elements.text());
        }

        return String.valueOf(stringBuilder);
    }
}