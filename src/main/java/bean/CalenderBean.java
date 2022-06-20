package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.CalenderVo;

public class CalenderBean {
	
	private Date DishDate;
	private String Dishname;
	private String bikou;

	
	public Date getDishDate() {
		return DishDate;
	}

	public void setDishDate(Date dishDate) {
		DishDate = dishDate;
	}

	public String getDishname() {
		return Dishname;
	}

	public void setDishname(String dishname) {
		Dishname = dishname;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	private List<CalenderVo> dishList = new ArrayList<CalenderVo>( );

	public List<CalenderVo> getDishList() {
		return dishList;
	}

	public void setDishList(List<CalenderVo> dishList) {
		this.dishList = dishList;
	}
}
