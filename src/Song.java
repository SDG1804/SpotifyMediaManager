package src;

public class Song {

    private String artist;
    private String songs;

    public Song(String artist, String songs) {
        this.artist = artist;
        this.songs = songs;
    }

    public static SongBuilder builder() {
        return new SongBuilder();
    }

    public static class SongBuilder {
        private String artist;
        private String songs;

        SongBuilder() {
        }

        public SongBuilder artist(String artist) {
            this.artist = artist;
            return this;
        }

        public SongBuilder songs(String songs) {
            this.songs = songs;
            return this;
        }


        public Song build() {
            return new Song(artist, songs);
        }
    }

    @Override
    public String toString() {
        return "Your Song{" +
                "artist='" + artist + '\'' +
                ", song='" + songs + '\'' +
                '}';
    }

    public String getArtist() {
        return artist;
    }

    public String getSongs() {
        return songs;
    }





}
