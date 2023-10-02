package use_case;

import api.SongDB;
import org.json.JSONException;

public final class LogSongUseCase {
    private final SongDB songDB;

    public LogSongUseCase(SongDB songDB) {
        this.songDB = songDB;
    }

    public void logSong(String artist, String song) throws JSONException {
        songDB.logSong(artist, song);
    }
}
