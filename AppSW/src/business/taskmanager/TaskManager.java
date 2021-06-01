package business.taskmanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.exceptions.DatabaseErrorException;
import infraestructure.FactoryHelper;
import model.Task;
import persistence.task.TaskDataService;

public class TaskManager implements TaskManagerService {

	private TaskDataService dataService = null;

	@Override
	public List<Task> getTasksByState(long stateId) throws DatabaseErrorException {
		List<Task> tasks = new ArrayList<Task>();
		try {
			tasks = getDataService().getTaskListByState(stateId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
		return tasks;
	}

	@Override
	public boolean deleteTasks(long id) throws DatabaseErrorException {
		try {
			return getDataService().deleteTask(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean updateTasks(Task updated) throws DatabaseErrorException {
		try {
			return getDataService().updateTask(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean saveTasks(Task newTask) throws DatabaseErrorException {
		try {
			return getDataService().saveTask(newTask);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	private TaskDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getTaskDataService();
		}

		return dataService;
	}

}
