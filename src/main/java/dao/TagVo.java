package dao;

import java.io.Serializable;

public class TagVo implements Serializable
{

	public static final String TABLE = "TAG";

	private int		TagID;
	private String	TagName;

	public TagVo()
	{
		super( );

	}

	public TagVo( int tagID, String tagName )
	{
		super( );
		TagID	= tagID;
		TagName	= tagName;
	}

	public int getTagID()
	{
		return TagID;
	}

	public void setTagID( int tagID )
	{
		TagID = tagID;
	}

	public String getTagName()
	{
		return TagName;
	}

	public void setTagName( String tagName )
	{
		TagName = tagName;
	}

}