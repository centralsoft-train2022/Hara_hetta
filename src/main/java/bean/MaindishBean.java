package bean;

import java.util.ArrayList;
import java.util.List;

import dao.TagVo;

public class MaindishBean
{
	private List<TagVo> tagList = new ArrayList<TagVo>( );

	private String username;

	public List<TagVo> getTagList()
	{
		return tagList;
	}

	public void setTagList( List<TagVo> tagList )
	{
		this.tagList = tagList;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

}
