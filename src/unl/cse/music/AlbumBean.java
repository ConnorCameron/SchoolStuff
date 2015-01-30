package unl.cse.music;

import java.util.ArrayList;
import java.util.List;

public class AlbumBean {

	public Album getDetailedAlbum(int albumId) {

		Album a = new Album();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		

		String query = "SELECT AlbumID,AlbumTitle,AlbumYear,BandName,AlbumNumber, FROM Albums JOIN AlbumSongs ON Albums.AlbumID=AlbumSongs.AlbumID JOIN Songs ON AlbumSongs.SongID=Songs.SongID WHERE AlbumID="+albumId;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, AlbumId);
			rs = ps.executeQuery();
			if(rs.next()) {
				a.setAlbumId(AlbumId);
				a.setTitle(rs.getString("AlbumTitle"));
				a.setYear(AlbumYear));
				a.setBand(rs.getString("BandName"));
				a.setAlbumNumber(rs.getString("AlbumNumber"));
				a.songTitles.add(rs.getString("SondTitle"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		return a;
	}
	
	public List<Album> getAlbums() {
		
		List<Album> albums = new ArrayList<Album>();
		/*
		 * Query the database and get all the albums in the 
		 * database with all the necessary fields, then construct
		 * Album objects and add them to the albums array
		 */
		return albums;
	}
	
	/**
	 * Before exporting to a WAR file and deploying to glassfish, you can
	 * test your method implementations using this main:
	 * @param args
	 */
	public static void main(String args[]) {
		
		System.out.println("Albums: ");
		AlbumBean ab = new AlbumBean();
		for(Album a : ab.getAlbums()) {
			System.out.println("\t"+a.getTitle()+" (id = "+a.getAlbumId()+")");
		}
		
		Album da = null; 
		try {
			da = ab.getAlbums().iterator().next();
		} catch (Exception e) {
			System.out.println("No albums returned in the list");
		}
		if(da != null) {
			System.out.println(da.getTitle()+" details: ");
			for(String trackTitle : da.getSongTitles()) {
				System.out.println("\t"+trackTitle);
			}
		}
	}
}
