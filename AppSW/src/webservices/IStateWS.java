package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.State;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IStateWS {
	
	@WebMethod
	public List<State> getStatesFromPanel(long panelId);
	
	@WebMethod
	public boolean deleteState(long id);
	
	@WebMethod
	public boolean updateState(State updated);
	
	@WebMethod
	public boolean saveState(State newState);

}
