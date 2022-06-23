package dao;

import java.io.Serializable;
import java.sql.Date;

public class DishVo implements Serializable
{

	public static final String TABLE = "MAINDISH";

	private int				DishID;
	private Date DishDate;
	private String			DishName;
	private String			DishBikou;
	private int				User_UserID;
	private int				Tag_TagID;
	private int				TagCount;
	private String			TagName;

	
	

	public String getTagName()
	{
		return TagName;
	}

	public void setTagName( String tagName )
	{
		TagName = tagName;
	}

	public int getTagCount()
	{
		return TagCount;
	}

	public void setTagCount( int tagCount )
	{
		TagCount = tagCount;
	}

	public DishVo()
	{
		super( );
	}

	public DishVo( Date dishDate, String dishName )
	{
		super( );
		this.DishDate	= dishDate;
		this.DishName	= dishName;
	}

	public int getDishID()
	{
		return DishID;
	}

	public void setDishID( int dishID )
	{
		DishID = dishID;
	}

	public java.sql.Date getDishDate()
	{
		return this.DishDate;
	}

	public void setDishDate( java.sql.Date dishDate )
	{
		this.DishDate = dishDate;
	}

	public String getDishName()
	{
		return this.DishName;
	}

	public void setDishName( String dishName )
	{
		this.DishName = dishName;
	}

	public String getDishBikou()
	{
		return DishBikou;
	}

	public void setDishBikou( String dishBikou )
	{
		DishBikou = dishBikou;
	}

	public int getUser_UserID()
	{
		return User_UserID;
	}

	public void setUser_UserID( int user_UserID )
	{
		User_UserID = user_UserID;
	}

	public int getTag_TagID()
	{
		return Tag_TagID;
	}

	public void setTag_TagID( int tag_TagID )
	{
		Tag_TagID = tag_TagID;
	}

	@Override
	public String toString() {
		return "DishVo [DishID=" + DishID + ", DishDate=" + DishDate + ", DishName=" + DishName + ", DishBikou="
				+ DishBikou + ", User_UserID=" + User_UserID + ", Tag_TagID=" + Tag_TagID + ", TagCount=" + TagCount
				+ ", TagName=" + TagName + "]";
	}

}
