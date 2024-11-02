
/**
 * We build this interface to represent the backend for a streaming radio service.
 * There are some methods for managing songs, stations, users, and user ratings
 * to offer personalized radio streaming experiences.
 */
public interface StreamingRadio {

    /**
     * We will add new songs to the system.
     * 
     * @param song The song to be added to the system.
     * @throws NullPointerException Check if the song is null.
     */
    void addSong(Song song);

    /**
     * Removes an existing song from the system.
     * 
     * @param song The song to be removed from the system.
     * @throws NullPointerException We need check if the song is null.
     * @throws IllegalArgumentException if the song does not exist in the system.
     */
    void removeSong(Song song);

    /**
     * Adds an existing song to the playlist for an existing radio station.
     * 
     * @param song The song to be added to the station's playlist.
     * @param station The radio station to which the song should be added.
     * @throws NullPointerException if either the song or the station is null.
     * @throws IllegalArgumentException Verify the song or station does not exist in the system.
     */
    void addToStation(Song song, Station station);

    /**
     * Removes a song from the playlist for a radio station.
     * 
     * @param song The song to be removed from the station's playlist.
     * @param station The radio station from which the song should be removed.
     * @throws NullPointerException if either the song or the station is null.
     * @throws IllegalArgumentException if the song or station does not exist in the system or if the song is not part of the station's playlist.
     */
    void removeFromStation(Song song, Station station);

    /**
	 * Since the system is intended to be personalized for individual users
	 * We need to know which user is rating a song to store their specific rating and use it for future recommendations.
     * So I want to set a user's rating for a song, as a number of stars from 1 to 5.
     * 
     * @param user The user providing the rating.
     * @param song The song being rated.
     * @param rating The rating value.
     * @throws NullPointerException if either the user or the song is null.
     * @throws IllegalArgumentException Check if the rating is not between 1 and 5, or if the song does not exist in the system.
     */
    void rateSong(User user, Song song, int rating);

    /**
     * Clears a user's rating on a song. If this user has rated this song and
     * the rating has not already been cleared, then the rating is cleared and
     * the state will appear as if the rating was never made. If there is no
     * such rating on record, then we will
     * throw an IllegalArgumentException.
     *
     * @param theUser user whose rating should be cleared
     * @param theSong song from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a
     * rating on record for the song
     * @throws NullPointerException if either the user or the song is null
     */
    void clearRating(User theUser, Song theSong) throws IllegalArgumentException, NullPointerException;

    /**
     * Our system then predict the rating a user will assign to a song that they have not yet rated, as a number of stars from 1 to 5.
     * 
     * @param user The user for whom the rating is being predicted.
     * @param song The song for which the rating is being predicted.
     * @return The predicted rating as an integer between 1 and 5.
     * @throws NullPointerException if either the user or the song is null.
     * @throws IllegalArgumentException if the song does not exist in the system.
     */
    int predictRating(User user, Song song);

    /**
     * Then suggests a song for a user that they are predicted to like.
     * 
     * @param user The user for whom the song is being suggested.
     * @return A suggested song that the user is predicted to like.
     * @throws NullPointerException if the user is null.
     * @throws IllegalArgumentException Throw if there are no songs available for suggestion.
     */
    Song suggestSong(User user);
}
