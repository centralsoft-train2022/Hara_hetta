package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.CalenderVo;

public class CalenderBean
{

	private String	DishName;
	private String	Bikou;
	private int		ToDayDish;


	private List<CalenderVo> dishList = new ArrayList<CalenderVo>( );

	public List<CalenderVo> getDishList()
	{
		return dishList;
	}

	public void setDishList( List<CalenderVo> dishList )
	{
		this.dishList = dishList;
	}

	public String getDishName()
	{

		return DishName;
	}

	public void setDishName( String dishName )
	{

		DishName = dishName;
	}

	public String getBikou()
	{

		return Bikou;
	}

	public void setBikou( String bikou )
	{

		Bikou = bikou;
	}

	public int getToDayDish()
	{

		return ToDayDish;
	}

	public void setToDayDish( int toDayDish )
	{

		ToDayDish = toDayDish;
	}
}
