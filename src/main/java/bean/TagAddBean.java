package bean;

public class TagAddBean
{

	private String	TagName;
	private int		WarningSetting;
	private int		WarningCount;
	private String	WarningSttingName;

	public TagAddBean()
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

	public int getWarningSetting()
	{
		return WarningSetting;
	}

	public void setWarningSetting( int warningSetting )
	{
		WarningSetting = warningSetting;
	}

	public int getWarningCount()
	{
		return WarningCount;
	}

	public void setWarningCount( int warningCount )
	{
		WarningCount = warningCount;
	}

	public String getWarningSttingName()
	{

		return WarningSttingName;
	}

	public void setWarningSttingName( String warningSttingName )
	{
		int i = getWarningSetting( );

		switch (i)
		{
			case 1:
				WarningSttingName = "1週間";
				break;
			case 2:
				WarningSttingName = "2週間";
				break;
			case 3:
				WarningSttingName = "1ヵ月";
				break;
		}
	}

}