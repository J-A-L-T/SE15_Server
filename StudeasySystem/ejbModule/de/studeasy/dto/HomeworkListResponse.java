package de.studeasy.dto;

import java.util.List;

import de.studeasy.common.IHomeworkListResponse;
import de.studeasy.common.IHomeworkTO;


public class HomeworkListResponse extends ReturncodeResponse implements IHomeworkListResponse {
	
	
	private static final long serialVersionUID = -3082296295638916589L;
	
	private List<IHomeworkTO> homeworklist; 
	
	@Override
	public List<IHomeworkTO> getHomeworkList(){
		return homeworklist;
	}
	
		
	@Override
	public void setHomeworkList(List<IHomeworkTO> homeworklist) {
		this.homeworklist = homeworklist;
		
	}
}
