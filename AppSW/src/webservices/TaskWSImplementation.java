package webservices;

import java.util.List;

import javax.jws.WebService;

import business.taskmanager.TaskManagerService;
import infraestructure.FactoryHelper;
import model.Task;

@WebService(endpointInterface = "webservices.ITaskWS")
public class TaskWSImplementation implements ITaskWS {
	
	
	private TaskManagerService manager = null;

	@Override
	public List<Task> getTaskByState(long stateId) {
		return getManager().getTasksByState(stateId);
	}

	@Override
	public boolean deleteTask(long id) {
		return getManager().deleteTasks(id);
	}

	@Override
	public boolean updateTask(Task updated) {
		return getManager().updateTasks(updated);
	}

	@Override
	public boolean saveTask(Task newTask) {
		return getManager().saveTasks(newTask);
	}
	
	private TaskManagerService getManager() {
		if(manager == null) {
			manager = FactoryHelper.services.getTaskManagerService();
		}
		
		return manager;
	}

}
