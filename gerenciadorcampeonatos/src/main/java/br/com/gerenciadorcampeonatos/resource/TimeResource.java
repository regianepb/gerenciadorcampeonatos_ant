package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.TimeDao;
import br.com.gerenciadorcampeonatos.modelo.Times;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("times")
public class TimeResource {

    private TimeDao timeDao = new TimeDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Times> buscarTodosTimes() {
        return timeDao.buscarTodosTimes();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Times buscarTime(@PathParam("id") long id) {
        return timeDao.buscarTime(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Times criarTime(Times time) {
        return timeDao.criarTime(time);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Times atualizarTime(Times time) {
        return timeDao.atualizarTime(time);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removerTime(@PathParam("id") long id) {
        timeDao.removerTime(id);
    }

}
