package use_case;

import api.SongDB;
import entity.Song;

public final class GetSongUseCase {
    private final SongDB songDB;

    public GetSongUseCase(SongDB songDB) {
        this.songDB = songDB;
    }

    public Song getSong(String artist, String songs) {
        return songDB.getSong(artist, songs);
    }
}
