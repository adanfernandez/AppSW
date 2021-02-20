package business.taskmanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infraestructure.FactoryHelper;
import model.Task;
import persistence.task.TaskDataService;

public class TaskManager implements TaskManagerService {

	private TaskDataService dataService = null;

	@Override
	public List<Task> getTasksByState(long stateId) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			tasks = getDataService().getTaskListByState(stateId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return tasks;
	}

	@Override
	public boolean deleteTasks(long id) {
		try {
			return getDataService().deleteTask(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTasks(Task updated) {
		try {
			return getDataService().updateTask(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveTasks(Task newTask) {
		try {
			return getDataService().saveTask(newTask);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	private TaskDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getTaskDataService();
		}

		return dataService;
	}

}
