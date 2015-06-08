package de.studeasy.common;

import java.util.List;

public interface IHomeworkListResponse extends IReturncodeResponse {
	
	public List<IHomeworkTO> getHomeworkList();
	
	public void setHomeworkList(List<IHomeworkTO> homeworklist); 

}
