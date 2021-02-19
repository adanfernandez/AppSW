package persistence.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import model.Task;

public interface TaskDataService {
	
	Connection getConnection();
	
	public List<Task> getTaskListByState(long stateId) throws SQLException;
		
	public boolean updateTask(Task uptdateTask, long taskId) throws SQLException;
	
	public boolean saveTask(Task newTask) throws SQLException;
	
	public boolean deleteTask(long taskId) throws SQLException;

}
