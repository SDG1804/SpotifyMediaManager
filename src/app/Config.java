package app;

import api.MongoArtistDB;
import api.MongoSongDB;
import api.SongDB;
import api.ArtistDB;
import use_case.GetSongUseCase;
import use_case.GetArtistUseCase;
import use_case.LogSongUseCase;

public class Config {
    private final SongDB songDB = new MongoSongDB();
    private final ArtistDB artistDB = new MongoArtistDB();

    public GetSongUseCase getSongUseCase() {
        return new GetSongUseCase(songDB);
    }

    public LogSongUseCase logSongUseCase() {
        return new LogSongUseCase(songDB);
    }

    public GetArtistUseCase getUserUseCase() {
        return new GetArtistUseCase(artistDB);
    }
}
