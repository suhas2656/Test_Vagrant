import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class RecentlyPlayedSongs {
    private final int songCount;
    private final Map<String, LinkedList<String>> songs;

    public RecentlyPlayedSongs(int capacity) {
        this.songCount = capacity;
        this.songs = new LinkedHashMap<>();
    }

    public void addSong(String user, String song) {
        LinkedList<String> songPlaylist = songs.getOrDefault(user, new LinkedList<>());

        // Remove the oldest song if the playlist is full
        if (songPlaylist.size() >= songCount) {
            songPlaylist.removeFirst();
        }

        // Add the new song to the end of the playlist
        songPlaylist.add(song);

        // Update the user's playlist in the map
        songs.put(user, songPlaylist);
    }

    public LinkedList<String> getRecentlyPlayed(String user) {
        return songs.getOrDefault(user, new LinkedList<>());
    }

    public static void main(String[] args) {
    	
        RecentlyPlayedSongs store = new RecentlyPlayedSongs(3);
        store.addSong("User1", "Song 1");
        store.addSong("User1", "Song 2");
        store.addSong("User1", "Song S3");
        store.addSong("User1", "Song S4");
        store.addSong("User1", "S2");
        store.addSong("User1", "S1");

        System.out.println("User1's recently played songs: " + store.getRecentlyPlayed("User1"));
    }
}
