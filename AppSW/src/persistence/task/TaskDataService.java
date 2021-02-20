package persistence.task;

import java.sql.SQLException;
import java.util.List;

import model.Task;
import persistence.MySQLCon;

public interface TaskDataService {
	
	MySQLCon getDbConnection();
	
	public List<Task> getTaskListByState(long stateId) throws SQLException;
		
	public boolean updateTask(Task uptdateTask, long taskId) throws SQLException;
	
	public boolean saveTask(Task newTask) throws SQLException;
	
	public boolean deleteTask(long taskId) throws SQLException;

}
