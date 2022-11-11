import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.*;

@Path("/coffee")
public class CoffeeRestService {
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getAll(){
		List<Coffee> data=null;
		CoffeeDAO dao=new CoffeeDAO();
		data=dao.getAll();
		return data;
	}
	@POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
    public String postCoffee(Coffee cf) throws SQLException{
        String result = "Record entered: "+ cf.toString();
        System.out.println(result);
        CoffeeDAO dao=new CoffeeDAO();
        int r=dao.InsertCoffee(cf);
        if(r>0)
          return "Insert OK";
        else
          return "Insert Failed";	
    }
	@POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
    public String updateCoffee(Coffee cf) throws SQLException{
        String result = "Record entered: "+ cf.toString();
        System.out.println(result);
        CoffeeDAO dao=new CoffeeDAO();
        int r=dao.updateCoffeeSales(cf);
        if(r>0)
          return "update OK";
        else
          return "update Failed";	
    }
	@POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
    public String deleteCoffee(Coffee cf) throws SQLException{
        String result = "Record entered: "+ cf.toString();
        System.out.println(result);
        CoffeeDAO dao=new CoffeeDAO();
        int r=dao.deleteCoffee(cf);
        if(r>0)
          return "delete OK";
        else
          return "delete Failed";	
    }
}
