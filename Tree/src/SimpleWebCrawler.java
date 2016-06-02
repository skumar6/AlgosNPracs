import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Sanjeev on 6/2/2016.
 */
public class SimpleWebCrawler {

    public static void crawl(String url) throws IOException {
        HashSet visited = new HashSet();
        List<String> toVisit = new ArrayList<String>();
        toVisit.add(url);
        int count =0;

        while(!toVisit.isEmpty()){
            url=toVisit.remove(0);
            if(!visited.contains(url)){
                visited.add(url);
            Document doc = Jsoup.connect(url).get();
//            if(doc.text().contains("research"))
//                System.out.println(url);
            Elements ele = doc.select("a[href]");
            for(Element link : ele) {
                url = link.attr("abs:href");

                if(!toVisit.contains(url)) {
                    toVisit.add(url);
                    System.out.println(url);
                }
                }

            }
                System.out.println(visited.size());
        }
        }


    public static void main(String[] args){
        String url = "http://www.umbc.edu/";
        try {
            crawl(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
