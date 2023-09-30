package src;

import org.json.JSONException;

public interface SongDB {
    Song getSong(String artist, String song);

    Song logSong(String artist, String song) throws JSONException;


}
