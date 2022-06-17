package dao;

public class CalenderVo {
	public static final String TABLE = "MAINDISH";

	private java.sql.Date	DishDate;
	
	public CalenderVo() {
		super();
	}
	public java.sql.Date getDishDate() {
		return DishDate;
	}
	public void setDishDate(java.sql.Date dishDate) {
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
	private String			DishName;
	private String			DishBikou;
}
