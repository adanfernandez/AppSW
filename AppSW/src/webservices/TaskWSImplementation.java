package webservices;

import java.util.List;

import javax.jws.WebService;

import business.exceptions.DatabaseErrorException;
import business.taskmanager.TaskManagerService;
import infraestructure.FactoryHelper;
import model.Task;

@WebService(endpointInterface = "webservices.ITaskWS")
public class TaskWSImplementation implements ITaskWS {
	
	
	private TaskManagerService manager = null;

	@Override
	public List<Task> getTaskByState(long stateId) throws DatabaseErrorException {
		return getManager().getTasksByState(stateId);
	}

	@Override
	public boolean deleteTask(long id) throws DatabaseErrorException {
		return getManager().deleteTasks(id);
	}

	@Override
	public boolean updateTask(Task updated) throws DatabaseErrorException {
		return getManager().updateTasks(updated);
	}

	@Override
	public boolean saveTask(Task newTask) throws DatabaseErrorException {
		return getManager().saveTasks(newTask);
	}
	
	private TaskManagerService getManager() {
		if(manager == null) {
			manager = FactoryHelper.services.getTaskManagerService();
		}
		
		return manager;
	}

}
