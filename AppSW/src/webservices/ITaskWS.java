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
	public List<Task> getTaskByState(long id);

}
