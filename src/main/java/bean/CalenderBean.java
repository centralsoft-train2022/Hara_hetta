package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DishVo;

public class CalenderBean {

	private String DishName;
	private String Bikou;
	private int ToDayDish;
	private Date DishDate;

	private List<DishVo> dishList = new ArrayList<DishVo>();

	public List<DishVo> getDishList() {
		return dishList;
	}

	public void setDishList(List<DishVo> dishList) {
		this.dishList = dishList;
	}

	public String getDishName() {

		return DishName;
	}

	public void setDishName(String dishName) {

		DishName = dishName;
	}

	public String getBikou() {

		return Bikou;
	}

	public void setBikou(String bikou) {

		Bikou = bikou;
	}

	public int getToDayDish() {

		return ToDayDish;
	}

	public void setToDayDish(int toDayDish) {

		ToDayDish = toDayDish;
	}

	public Date getDishDate() {
		return DishDate;
	}

	public void setDishDate(Date dishDate) {
		DishDate = dishDate;
	}
	
	

}
