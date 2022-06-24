package bean;

import java.util.ArrayList;
import java.util.List;

import dao.DishVo;

public class DishTagAllBean {
	private List<DishVo> tagDishAllList = new ArrayList<DishVo>();
	private String sort;
	private String time;

	public List<DishVo> getTagList() {
		return tagDishAllList;
	}

	public void setTagList(List<DishVo> list) {
		this.tagDishAllList = list;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
