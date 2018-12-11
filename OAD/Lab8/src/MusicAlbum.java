public class MusicAlbum
{
	// TODO: Add Required annotation
	@Required
	// TODO: Add MinLength annotation, value 1
	@MinLength(value = 1, inclusive = true)
	// TODO: Add MaxLength annotation, value 5
	@MaxLength(value = 5, inclusive = true)
	private String id;

	// TODO: Add Required annotation
	@Required
	// TODO: Add MinLength annotation, value 5
	@MinLength(value = 5, inclusive = true)
	// TODO: Add MaxLength annotation, value 100
	@MaxLength(value = 100, inclusive = true)
	private String name;

	// TODO: Add MaxLength annotation, value 30
	@MaxLength(value = 30)
	private String genre;
	private boolean isCompilation;

	// TODO: Add Required annotation
	@Required
	@Min(value=0, inclusive=false)
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
