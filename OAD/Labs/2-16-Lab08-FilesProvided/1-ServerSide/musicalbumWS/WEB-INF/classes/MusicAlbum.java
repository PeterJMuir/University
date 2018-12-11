import validate.*;

public class MusicAlbum
{
	// TODO: Add Required annotation
	// TODO: Add MinLength annotation, value 2
	// TODO: Add MaxLength annotation, value 5
	@MinLength(value=2)
	@MaxLength(value=5)
	private String id;

	// TODO: Add Required annotation
	// TODO: Add MinLength annotation, value 5
	// TODO: Add MaxLength annotation, value 100
	@Required
	@MinLength(value=5)
	private String name;

	// TODO: Add MaxLength annotation, value 30
	private String genre;
	private boolean isCompilation;

	// TODO: Add Max annotation, value 50 inclusive
	//
	@Min(value=0, inclusive=false)
	@Max(value=50)
	private int trackCount;

	public MusicAlbum() {}
	public MusicAlbum(String id, String name, String genre, boolean isCompilation, int trackCount)
	{
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.isCompilation = isCompilation;
		this.trackCount = trackCount;
	}

	public void setCompilation(boolean isCompilation) {
		this.isCompilation = isCompilation;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public boolean isCompilation()
	{
		return isCompilation;
	}

	public int getTrackCount()
	{
		return trackCount;
	}

	public String toString()
	{
		return
			"\nMusicAlbum"
			+ "[id: " + id
			+ ", name: " + name
			+ ", genre: " + genre
			+ ", isCompilation: " + isCompilation
			+ ", trackCount: " + trackCount + "]";
	}

	public boolean equals(Object obj)
	{
		return
			obj != null &&
			obj instanceof MusicAlbum &&
			((MusicAlbum)obj).id == this.id;
	}
}
