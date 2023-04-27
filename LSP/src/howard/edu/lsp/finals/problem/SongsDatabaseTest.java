 package howard.edu.lsp.finals.problem;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import java.util.Set;
import static org.junit.Assert.*;

public class SongsDatabaseTest {
    @Test
    @DisplayName("test cases for adding song")
    public void addSongTest() {
        SongsDatabase database = new SongsDatabase(); //creating new database object
        database.addSong("Rap", "Children's Story"); //add song
        Assertions.assertTrue( 1 == database.getSong("Rap").size()); //check size and compare with expected result
        database.addSong("Rap", "Walkin");
        Assertions.assertTrue( 2 == database.getSong("Rap").size());
        database.addSong("Pop", "Baby Be Mine");
        Assertions.assertTrue( 1 == database.getSong("Pop").size());
        database.addSong("Pop", "Off the Wall");
        Assertions.assertTrue( 2 == database.getSong("Pop").size());
        database.addSong("Pop", "Do I Do");
        Assertions.assertTrue( 3 == database.getSong("Pop").size());
        database.addSong("EDM", "911");
        Assertions.assertTrue( 1 == database.getSong("EDM").size());
        database.addSong("Rap", "Work Out");
        Assertions.assertTrue( 3 == database.getSong("Rap").size());
        database.addSong("Alternative", "The Cruel Angel's Theme");
        Assertions.assertTrue( 1 == database.getSong("Alternative").size());
        //testing to make sure duplicate items does not get added
        database.addSong("Alternative", "The Cruel Angel's Theme");
        Assertions.assertTrue( 1 == database.getSong("Alternative").size());
        
        System.out.println(database.getSong("Rap"));
        System.out.println(database.getSong("Pop"));
        System.out.println(database.getSong("Alternative"));
    }

	@Test
	@DisplayName("Test cases for getting songs")
	public void getSongTest() {
		SongsDatabase database = new SongsDatabase();
		database.addSong("Rap", "Children's Story");
		database.addSong("Pop", "Baby Be Mine");
		database.addSong("Rap", "Work Out");
		database.addSong("Rap", "Walkin");
		database.addSong("Rap", "Players Anthem");
		database.addSong("Alternative", "Beneath The Mask");
		
		//creating sets that will have songs from each genre
		Set<String> PopSongs = database.getSong("Pop");
		Set<String> RapSongs = database.getSong("Rap");
		Set<String> AlternativeSongs = database.getSong("Alternative");
		
		assertTrue(PopSongs.contains("Baby Be Mine"));
		assertTrue(RapSongs.contains("Work Out"));
		assertTrue(RapSongs.contains("Walkin"));
		assertTrue(RapSongs.contains("Players Anthem"));
		assertTrue(AlternativeSongs.contains("Beneath The Mask"));
		
		//print songs per Genre
		System.out.println(database.getSong("Alternative"));
		System.out.println(database.getSong("Rap"));
		System.out.println(database.getSong("Pop"));
	}


	@Test
	@DisplayName("test cases for getting Genre of Song")
	public void getGenreTest() {
		SongsDatabase database = new SongsDatabase();
		database.addSong("Rap", "Children's Story");
		database.addSong("Pop", "Baby Be Mine");
		database.addSong("Rap", "Work Out");
		database.addSong("Rap", "Walkin");
		database.addSong("Rap", "Players Anthem");
		database.addSong("Alternative", "Beneath The Mask");
		
		assertEquals("Rap", database.getGenre("Work Out"));
        assertEquals("Pop", database.getGenre("Baby Be Mine"));
        assertEquals("Alternative", database.getGenre("Beneath The Mask"));
        //test that getGenre returns null if Genre is not found
        assertNull(database.getGenre("1234"));
        
        //print Genres per song
        System.out.println(database.getGenre("Work Out"));
        System.out.println(database.getGenre("Beneath The Mask"));
        System.out.println(database.getGenre("Baby Be Mine"));
	}
}