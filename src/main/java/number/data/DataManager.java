package number.data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import number.constants.URLs;
import number.models.number.Numbers;
import number.utils.http.HttpAdapter;
import number.utils.io.FileIO;
import okhttp3.Response;

/**
 * DataManager will download data from the API and save it to fileName. If
 * fileName is missing, default fileName FILE_NAME = "result.json" will be used.
 * After parsing the data file, the data will be cached in Numbers result
 * variable. To get data, call getData() or getData(FILE_NAME).
 */
@Slf4j
public class DataManager {
    private static DataManager instance;

    private DataManager() {
    }

    private DataManager(String fileName) {
        this.fileName = fileName;
    }

    public static synchronized DataManager getInstance(String fileName) {
        if (instance == null) {
            instance = new DataManager(fileName);
        }
        return instance;
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private static final Gson GSON = new Gson();
    private static final String TEMPLATE = URLs.TEMPLATE;

    private String fileName = "result";
    private Numbers data;

    public Numbers getData() {
        return this.data;
    }

    private URI getGzipFilePath() throws URISyntaxException {
        return DataManager.class.getResource("/data/" + fileName + ".gzip").toURI();
    }

    private URI getJsonFilePath() throws URISyntaxException {
        return DataManager.class.getResource("/data/" + fileName + ".json").toURI();
    }

    public DataManager downloadData() throws IOException, URISyntaxException {
        for(int id = 1 ; id < 7; ++id) {
            String url = String.format(TEMPLATE, id);
            Response response = HttpAdapter.get(url, null, null);
            Numbers responseData = GSON.fromJson(new InputStreamReader(response.body().byteStream()), Numbers.class);
            if (id == 1 && data != null && data.getDrawGameId().equals(responseData.getDrawGameId())) {
                break;
            }
            if (data != null && (data.getTotalPreviousDraws() == data.getPreviousDraws().size())) {
                break;
            }
            if (id == 1 || data == null) {
                data = responseData;
            } else {
                data.getPreviousDraws().addAll(responseData.getPreviousDraws());
            }
        }
        FileIO.saveAsJson(getGzipFilePath(), data);
        FileIO.saveAsJson(getJsonFilePath(), data);
        log.info("Data download DONE");
        return this;
    }
}