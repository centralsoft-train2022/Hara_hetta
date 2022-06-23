package dao;

import java.io.Serializable;

public class WarningVo implements Serializable
{

	public static final String TABLE = "TAGWARNINGPATTERN";

	private String	TagName;
	private int		WarningCount;

	public WarningVo()
	{
		super( );
	}

	public String getTagName()
	{
		return TagName;
	}

	public void setTagName( String tagName )
	{
		TagName = tagName;
	}

	public int getWarningCount()
	{
		return WarningCount;
	}

	public void setWarningCount( int warningCount )
	{
		WarningCount = warningCount;
	}

}