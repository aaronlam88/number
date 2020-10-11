package jsoup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSoup {
    @Test
    public void read() throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("EEEE MMMM dd, yyyy");

        Document doc = Jsoup.connect("https://www.lottery.net/california/superlotto-plus/numbers/1986").get();
        Element table = doc.select("table[class=prizes archive]").first();
        Elements rows = table.select("tr");
        for (Element row : rows) {
            Elements cells = row.select("td");
            if(!cells.isEmpty()) {
                String dateStr = cells.get(0).text();
                Date date =  format.parse(dateStr);

                log.info(date.toInstant().toString());
                log.info(cells.get(1).text());
            }
        }
    }
}
