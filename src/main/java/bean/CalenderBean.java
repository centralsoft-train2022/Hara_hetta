package bean;

import java.util.ArrayList;
import java.util.List;

import dao.DishVo;

public class CalenderBean {

	
	private List<DishVo> dishList = new ArrayList<DishVo>( );

	public List<DishVo> getDishList() {
		return dishList;
	}

	public void setDishList(List<DishVo> dishList) {
		this.dishList = dishList;
	}
}
