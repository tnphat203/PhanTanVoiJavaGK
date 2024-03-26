package entity;

public class Album_detail {
	private String albumId;
	private String artistId;

	public Album_detail() {
	}

	public Album_detail(String albumId, String artistId) {
		this.albumId = albumId;
		this.artistId = artistId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	@Override
	public String toString() {
		return "Album_detail [albumId=" + albumId + ", artistId=" + artistId + "]";
	}

}
