package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.TimeDao;
import br.com.gerenciadorcampeonatos.modelo.Times;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("times")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeResource {

    private TimeDao timeDao = new TimeDao();

    @GET
    public List<Times> buscarTimes() {
        System.out.println("Método GET 'buscarTimes'");
        return timeDao.buscarTimes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Times criaTime(Times time) {
        System.out.println("Método POST 'create'");
        return timeDao.criaTime(time);
    }

}
