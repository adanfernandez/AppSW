package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Task;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ITaskWS {
	
	@WebMethod
	public List<Task> getTaskByState(long stateId);
	
	@WebMethod
	public boolean deleteTask(long id);
	
	@WebMethod
	public boolean updateTask(Task updated);
	
	@WebMethod
	public boolean saveTask(Task newTask);

}
