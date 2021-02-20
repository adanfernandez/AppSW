package business.taskmanager;

import java.util.List;

import model.Task;

public interface TaskManagerService {

public List<Task> getTasksByState(long stateId);
	
	public boolean deleteTasks(long id);
	
	public boolean updateTasks(Task updated);
	
	public boolean saveTasks(Task newTask);
}
