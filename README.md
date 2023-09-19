# SongsList Utility
## Overview
**File Name:** SongsList.java

**Version:** 1.0

**Date:** 13 Sept 2023

**Project:** TestVagrant Assignment

**Author:** Suhas

**E-Mail:** Suhashgs.58@gmail.com

**Description:**
This Java class serves as a utility for managing playlists of songs for multiple users.
It includes functionality to add songs to a user's playlist, retrieve recently played songs, and manage the maximum number of songs a playlist can hold.

### How to Use
**Construction:**

To create a new SongsList object, you need to provide the maximum number of songs a playlist can have.

Example:

SongsList user1PlayedSongs = new SongsList(3);
SongsList user2PlayedSongs = new SongsList(3);

Adding Songs:

You can add songs to a user's playlist using the addSong method. It takes the user's name and the song to be added.

Example:
user1PlayedSongs.addSong("User1", "Song 1");

Getting Recently Played Songs:

Use the getRecentlyPlayed method to retrieve a user's recently played songs. It takes the user's name and returns a linked list of songs.

LinkedList<String> user1Songs = user1PlayedSongs.getRecentlyPlayed("User1");



In the provided main method, there are examples of how to create SongsList objects, add songs, and retrieve recently played songs for two users (User1 and User2).

Example:
System.out.println("User1's recently played songs: " + user1PlayedSongs.getRecentlyPlayed("User1"));
System.out.println("User2's recently played songs: " + user2PlayedSongs.getRecentlyPlayed("User2"));

## Features

Create user-specific playlists with a maximum song count.
Add songs to a user's playlist.
Automatically remove the oldest song if the playlist is full.
Retrieve a user's recently played songs.

## Project run
To use the SongsList utility, follow these steps:

1.Include the SongsList.java file in your Java project.

2.Create SongsList objects for different users, specifying the maximum song count for each playlist.

3.Add songs to the users' playlists using the addSong method.

4.Retrieve a user's recently played songs using the getRecentlyPlayed method.
