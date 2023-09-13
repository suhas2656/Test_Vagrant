/**
 * * ****************************************************************
 * *      File Name       : SongsList.java
 * *      Version         : 1.0
 * *      Date            : 13 Sept 2023
 * *      Project         : TestVagrant Assignment
 * *      Authors         : Suhas
 * *      E-Mail          : Suhashgs.58@gmail.com
 * *      Description     : Utility class for date time operations
 * * ******************************************************************
 * * ******************************************************************
 * * Date           |  Version    |  Author            |  Reviewer         |  Reason for Change                                             |
 * * 13 Sept 2023   |    1.0      | Suhas              |  TestVagrant Team |  Draft Code                                                    |                               |
 * *******************************************************************
 */
package TestVagrant;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SongsList {

    // The maximum number of songs a playlist can hold.
    final int songCount;

    // A map that stores user playlists as linked lists of songs.
    final Map<String, LinkedList<String>> songs;

    /**
     * Constructs a SongsList object with a specified maxNoofSongs.
     *
     * @param maxNoofSongs The maximum number of songs a playlist can hold.
     */
    public SongsList(int maxNoofSongs) {
        this.songCount = maxNoofSongs;
        this.songs = new LinkedHashMap<>();
    }

    /**
     * Adds a song to a user's playlist.
     *
     * @param user The user for whom the song is being added.
     * @param song The name of the song to be added.
     */
    public void addSong(String user, String song) {
        LinkedList<String> songPlaylist = songs.getOrDefault(user, new LinkedList<>());

        // Remove the oldest song if the playlist is full.
        if (songPlaylist.size() >= songCount) {
            songPlaylist.removeFirst();
        }

        // Add the newly played song to the playlist.
        songPlaylist.add(song);

        // Update the user's playlist in the map.
        songs.put(user, songPlaylist);
    }

    /**
     * Retrieves a user's recently played songs.
     *
     * @param user The user for whom recently played songs are requested.
     * @return A linked list containing the user's recently played songs.
     */
    public LinkedList<String> getRecentlyPlayed(String user) {
        return songs.getOrDefault(user, new LinkedList<>());
    }

    /**
     * The main method where the program execution starts
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create SongsList objects for two users.
        SongsList user1PlayedSongs = new SongsList(3);
        SongsList user2PlayedSongs = new SongsList(3);

        // Add songs to User1's playlist.
        user1PlayedSongs.addSong("User1", "Song 1");
        user1PlayedSongs.addSong("User1", "Song 2");
        user1PlayedSongs.addSong("User1", "Song 3");
        user1PlayedSongs.addSong("User1", "Song 1");
        user1PlayedSongs.addSong("User1", "Song 3");
        user1PlayedSongs.addSong("User1", "Song 4");

        // Add songs to User2's playlist.
        user2PlayedSongs.addSong("User2", "Song 1");
        user2PlayedSongs.addSong("User2", "Song 2");
        user2PlayedSongs.addSong("User2", "Song 3");
        user2PlayedSongs.addSong("User2", "Song 4");
        user2PlayedSongs.addSong("User2", "Song 3");
        user2PlayedSongs.addSong("User2", "Song 1");

        // Display the recently played songs for User1 and User2.
        System.out.println("User1's recently played songs: " + user1PlayedSongs.getRecentlyPlayed("User1"));
        System.out.println("User2's recently played songs: " + user2PlayedSongs.getRecentlyPlayed("User2"));
    }
}
