package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import business.exceptions.DatabaseErrorException;
import model.Panel;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IPanelWS {
	
	@WebMethod
	public List<Panel> getPanelsFromUser(long userId) throws DatabaseErrorException;
	
	@WebMethod
	public boolean deletePanel(long id) throws DatabaseErrorException;
	
	@WebMethod
	public boolean updatePanel(Panel updated) throws DatabaseErrorException;
	
	@WebMethod
	public boolean savePanel(Panel newPanel) throws DatabaseErrorException;

}
