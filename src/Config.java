public class Config {
    private final SongDB songDB = new MongSong();

    public GetSongUseCase getSongUseCase() {
        return new GetSongUseCase(songDB);
    }

    public LogSongUseCase logSongUseCase() {
        return new LogSongUseCase(songDB);
    }


}
