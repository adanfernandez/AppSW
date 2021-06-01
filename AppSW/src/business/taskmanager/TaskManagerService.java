package business.taskmanager;

import java.util.List;

import business.exceptions.DatabaseErrorException;
import model.Task;

public interface TaskManagerService {

public List<Task> getTasksByState(long stateId) throws DatabaseErrorException;
	
	public boolean deleteTasks(long id) throws DatabaseErrorException;
	
	public boolean updateTasks(Task updated) throws DatabaseErrorException;
	
	public boolean saveTasks(Task newTask) throws DatabaseErrorException;
}
