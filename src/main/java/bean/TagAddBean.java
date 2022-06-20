package bean;

public class TagAddBean
{

	private String	TagName;
	private int		WarningSetting;
	private int		WarningCount;
	private String	WarningSetingName;

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

	public String getWarningSetingName()
	{

		return WarningSetingName;
	}

	public void setWarningSetingName( String warningSetingName )
	{
		int i = getWarningSetting( );

		switch (i)
		{
			case 1:
				WarningSetingName = "1週間";
				break;
			case 2:
				WarningSetingName = "2週間";
				break;
			case 3:
				WarningSetingName = "1ヵ月";
				break;
		}
	}

}