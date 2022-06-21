package bean;

import java.util.ArrayList;
import java.util.List;

import dao.DishVo;

public class DishTagAllBean
{
	private List<DishVo> tagDishAllList = new ArrayList<DishVo>( );

	public List<DishVo> getTagList()
	{
		return tagDishAllList;
	}

	public void setTagList( List<DishVo> list )
	{
		this.tagDishAllList = list;
	}

}
