package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import business.exceptions.DatabaseErrorException;
import model.State;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IStateWS {
	
	@WebMethod
	public List<State> getStatesFromPanel(long panelId) throws DatabaseErrorException;
	
	@WebMethod
	public boolean deleteState(long id) throws DatabaseErrorException;
	
	@WebMethod
	public boolean updateState(State updated) throws DatabaseErrorException;
	
	@WebMethod
	public boolean saveState(State newState) throws DatabaseErrorException;

}
