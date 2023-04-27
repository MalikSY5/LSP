package howard.edu.lsp.finals.problem;
import java.util.HashMap;
import java.util.HashSet;

public class SongsDatabase {
    /* Key is the genre, HashSet contains associated songs */
    private HashMap<String, HashSet<String>> database = new HashMap<String, HashSet<String>>();

    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        HashSet<String> song = database.get(genre);
        if (song == null) {
            song = new HashSet<String>();
            database.put(genre, song);
        }
        song.add(songTitle);
    }

    /* Return the Set that contains all songs for a genre */
    public HashSet<String> getSong(String genre) {
        HashSet<String> song = database.get(genre);
        if (song == null) {
            song = new HashSet<String>();
        }
        return song;
    }

    /* Return genre, i.e., jazz, given a song title */
    public String getGenre(String songTitle) {
        for (String genre : database.keySet()) {
            HashSet<String> song = database.get(genre);
            if (song.contains(songTitle)) {
                return genre;
            }
        }
        return null;
    }
}
