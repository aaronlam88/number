/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package number;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import number.models.Draw;
import number.models.Result;
import number.models.WinningNumbers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {

    public static void main(String[] args) {
        int id = 1;
        Map<Integer, WinningNumbers> map = new HashMap<>();
        while (true) {
            String format = number.constants.URL.template;
            String url = String.format(format, id++);
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder().url(url).method("GET", null).build();
            try {
                Response response = client.newCall(request).execute();
                if (!response.isSuccessful()) {
                    break;
                }
                JsonElement jsonElement = JsonParser.parseString(response.body().string());
                Result result = new Gson().fromJson(jsonElement, Result.class);
                if (result.getMostRecentDraw() == null || result.getTotalPreviousDraws() == map.size()) {
                    break;
                }
                for (Draw draw : result.getPreviousDraws()) {
                    map.put(draw.getDrawNumber(), draw.getWinningNumbers());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(map.size());
        // for (Map.Entry<Integer, WinningNumbers> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
    }
}