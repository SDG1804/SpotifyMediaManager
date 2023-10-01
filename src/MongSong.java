import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MongSong implements SongDB {
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    @Override
    public Song getSong(String artist, String song) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://grade-logging-api.chenpan.ca/song?song=%s&artist=%s", song, artist))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    @Override
    public Song logSong(String artist, String song) throws JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        requestBody.put("artist", artist);
        requestBody.put("song", song);
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://grade-logging-api.chenpan.ca/grade")
                .method("POST", body)
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
