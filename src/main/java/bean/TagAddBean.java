package bean;

public class TagAddBean {

	private String TagName;
	private int WarningSetting;
	private int WarningCount;

	public TagAddBean() {
		super();
	}

	public String getTagName() {
		return TagName;
	}

	public void setTagName(String tagName) {
		TagName = tagName;
	}

	public int getWarningSetting() {
		return WarningSetting;
	}

	public void setWarningSetting(int warningSetting) {
		WarningSetting = warningSetting;
	}

	public int getWarningCount() {
		return WarningCount;
	}

	public void setWarningCount(int warningCount) {
		WarningCount = warningCount;
	}

}