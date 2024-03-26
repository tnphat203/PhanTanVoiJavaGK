package entity;

public class Song {
	private String albumId;
	private String fileLink;
	private String id;
	private String name;
	private String lyric;
	private String runtime;

	public Song() {
	}

	public Song(String albumId, String fileLink, String id, String name, String lyric, String runtime) {
		this.albumId = albumId;
		this.fileLink = fileLink;
		this.id = id;
		this.name = name;
		this.lyric = lyric;
		this.runtime = runtime;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "Song [albumId=" + albumId + ", fileLink=" + fileLink + ", id=" + id + ", name=" + name + ", lyric="
				+ lyric + ", runtime=" + runtime + "]";
	}

}
