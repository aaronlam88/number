package number.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import number.models.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataManagement {
    private static Logger logger = LoggerFactory.getLogger(DataManagement.class);
    private static Gson gson = new Gson();

    private static String TEMPLATE = number.constants.URL.template;
    private static String FILE_NAME = "result.json";
    private static Result RESULT;

    public static Result getResult(String fileName) throws IOException {
        if (RESULT == null) {
            downloadData(fileName);
        }
        return RESULT;
    }

    public static Result getResult() throws IOException {
        return getResult(FILE_NAME);
    }

    public static void downloadData() throws IOException {
        downloadData(FILE_NAME);
    }

    public static void downloadData(String fileName) throws IOException {
        boolean loadFromFile = false;
        try {
            RESULT = loadFromFile(fileName);
            loadFromFile = true;
        } catch (Exception e) {
            logger.debug("Cannot load data from file " + fileName);
        }
        boolean shouldSave = true;
        int id = 1;
        while (true) {
            String url = String.format(TEMPLATE, id);
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder().url(url).method("GET", null).build();
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                break;
            }
            JsonElement jsonElement = JsonParser.parseString(response.body().string());
            Result responseData = gson.fromJson(jsonElement, Result.class);
            if (responseData.getMostRecentDraw() == null) {
                break;
            }
            if (loadFromFile && RESULT != null && RESULT.getNextDraw() != null
                    && RESULT.getNextDraw().getDrawDate().equals(responseData.getNextDraw().getDrawDate())) {
                shouldSave = false;
                break;
            }
            if (id == 1) {
                RESULT = responseData;
            } else {
                RESULT.getPreviousDraws().addAll(responseData.getPreviousDraws());
            }
            ++id;
        }
        if (shouldSave) {
            saveToFile(fileName, RESULT);
        }
        logger.info("Data download DONE");
    }

    public static void saveToFile(String fileName, Object obj) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(gson.toJson(obj));
        bufferedWriter.close();
        logger.debug("Object is writen to " + fileName);
    }

    public static Result loadFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        RESULT = gson.fromJson(bufferedReader, Result.class);
        bufferedReader.close();
        return RESULT;
    }
}