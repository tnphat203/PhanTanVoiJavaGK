package entity;

public class Album {
	private String id;
	private double price;
	private String title;
	private String downloadLink;
	private String genreId;
	private int yearOfRelease;

	public Album() {
	}

	public Album(String id, double price, String title, String downloadLink, String genreId, int yearOfRelease) {
		this.id = id;
		this.price = price;
		this.title = title;
		this.downloadLink = downloadLink;
		this.genreId = genreId;
		this.yearOfRelease = yearOfRelease;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", price=" + price + ", title=" + title + ", downloadLink=" + downloadLink
				+ ", genreId=" + genreId + ", yearOfRelease=" + yearOfRelease + "]";
	}

}
