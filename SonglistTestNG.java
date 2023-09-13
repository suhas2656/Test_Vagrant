/**
 * * ****************************************************************
 * *      File Name       : SonglistTestNG.java
 * *      Version         : 1.0
 * *      Date            : 13 Sept 2023
 * *      Project         : TestVagrant Assignment
 * *      Authors         : Suhas
 * *      E-Mail          : Suhashgs.58@gmail.com
 * *      Description     : These test methods help ensure that the RecentlyPlayedSongs class behaves as expected and meets the requirements 
                              for managing playlists and adding songs for different users while maintaining a maximum count of songs
 * * ******************************************************************
 * * ******************************************************************
 * * Date           |  Version    |  Author            |  Reviewer         |  Reason for Change                                             |
 * * 13 Sept 2023   |    1.0      | Suhas              |  TestVagrant Team |  Draft Code                                                    |                               |
 * *******************************************************************
 */
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class SonglistTestNG {

    /**
     * Test case to verify the functionality of adding songs to a user's recently played playlist.
     * It checks if songs are added correctly, limited to a specified maximum count,
     * and if the most recent songs are at the end of the playlist.
     */
    @Test
    public void testAddingSongs() {
        RecentlyPlayedSongs store = new RecentlyPlayedSongs(3);

        // Add songs for User1
        store.addSong("User1", "Song 1");
        store.addSong("User1", "Song 2");
        store.addSong("User1", "Song 3");

        LinkedList<String> user1RecentlyPlayed = store.getRecentlyPlayed("User1");

        // Check if User1's recently played songs match the expected songs
        Assert.assertEquals(user1RecentlyPlayed, List.of("Song 1", "Song 2", "Song 3"));

        // Add more songs for User1
        store.addSong("User1", "Song 4");
        store.addSong("User1", "Song 5");

        user1RecentlyPlayed = store.getRecentlyPlayed("User1");

        // Check if User1's playlist still has a maximum of 3 songs
        Assert.assertEquals(user1RecentlyPlayed.size(), 3);

        // Check if the most recent songs are at the end of the playlist
        Assert.assertEquals(user1RecentlyPlayed, List.of("Song 3", "Song 4", "Song 5"));
    }

    /**
     * Test case to verify the functionality of adding songs for different users
     * and ensuring that each user's playlist contains their respective songs.
     */
    @Test
    public void testAddingSongsForDifferentUsers() {
        RecentlyPlayedSongs store = new RecentlyPlayedSongs(3);

        // Add songs for User1 and User2
        store.addSong("User1", "Song 1");
        store.addSong("User2", "Song A");
        store.addSong("User1", "Song 2");
        store.addSong("User2", "Song B");
        store.addSong("User1", "Song 3");

        LinkedList<String> user1RecentlyPlayed = store.getRecentlyPlayed("User1");
        LinkedList<String> user2RecentlyPlayed = store.getRecentlyPlayed("User2");

        // Check if each user's playlist contains their respective songs
        Assert.assertEquals(user1RecentlyPlayed, List.of("Song 1", "Song 2", "Song 3"));
        Assert.assertEquals(user2RecentlyPlayed, List.of("Song A", "Song B"));
    }
}
