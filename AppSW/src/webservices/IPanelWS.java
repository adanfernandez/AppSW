package webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Panel;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IPanelWS {
	
	@WebMethod
	public List<Panel> getPanelsFromUser(long userId);
	
	@WebMethod
	public boolean deletePanel(long id);
	
	@WebMethod
	public boolean updatePanel(Panel updated);
	
	@WebMethod
	public boolean savePanel(Panel newPanel);

}
