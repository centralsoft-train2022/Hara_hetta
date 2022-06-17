package bean;

import java.util.ArrayList;
import java.util.List;

import dao.CalenderVo;

public class CalenderBean {

	
	private List<CalenderVo> dishList = new ArrayList<CalenderVo>( );

	public List<CalenderVo> getDishList() {
		return dishList;
	}

	public void setDishList(List<CalenderVo> dishList) {
		this.dishList = dishList;
	}
}
