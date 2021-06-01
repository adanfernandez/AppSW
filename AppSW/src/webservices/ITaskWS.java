package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import business.exceptions.DatabaseErrorException;
import model.Task;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ITaskWS {
	
	@WebMethod
	public List<Task> getTaskByState(long stateId) throws DatabaseErrorException;
	
	@WebMethod
	public boolean deleteTask(long id) throws DatabaseErrorException;
	
	@WebMethod
	public boolean updateTask(Task updated) throws DatabaseErrorException;
	
	@WebMethod
	public boolean saveTask(Task newTask) throws DatabaseErrorException;

}
