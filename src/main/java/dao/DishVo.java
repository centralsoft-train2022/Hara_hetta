package dao;

import java.io.Serializable;
import java.util.Date;

public class DishVo implements Serializable {

	public static final String TABLE = "MAINDISH";

	private int DishID;
	private Date DishDate;
	private String DishName;
	private String DishBikou;
	private int User_UserID;
	private int Tag_TagID;

	public DishVo() {
		super();
	}

	public DishVo(Date dishDate, String dishName) {
		super();
		DishDate = dishDate;
		DishName = dishName;
	}

	public int getDishID() {
		return DishID;
	}

	public void setDishID(int dishID) {
		DishID = dishID;
	}

	public Date getDishDate() {
		return DishDate;
	}

	public void setDishDate(Date dishDate) {
		DishDate = dishDate;
	}

	public String getDishName() {
		return DishName;
	}

	public void setDishName(String dishName) {
		DishName = dishName;
	}

	public String getDishBikou() {
		return DishBikou;
	}

	public void setDishBikou(String dishBikou) {
		DishBikou = dishBikou;
	}

	public int getUser_UserID() {
		return User_UserID;
	}

	public void setUser_UserID(int user_UserID) {
		User_UserID = user_UserID;
	}

	public int getTag_TagID() {
		return Tag_TagID;
	}

	public void setTag_TagID(int tag_TagID) {
		Tag_TagID = tag_TagID;
	}

}
