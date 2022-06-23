package bean;

import java.util.ArrayList;
import java.util.List;

import dao.WarningVo;

public class WarningBean
{
	List<WarningVo> warningList = new ArrayList<WarningVo>( );

	public List<WarningVo> getWarningList()
	{
		return warningList;
	}

	public void setWarningList( List<WarningVo> warningList )
	{
		this.warningList = warningList;
	}

}