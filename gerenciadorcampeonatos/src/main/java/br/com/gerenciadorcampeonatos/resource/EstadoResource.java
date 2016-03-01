package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.EstadoDao;
import br.com.gerenciadorcampeonatos.modelo.Estados;
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

@Path("estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {
    private EstadoDao estadoDao = new EstadoDao();

    @GET
    public List<Estados> buscarTodosEstados() {
        return estadoDao.buscarTodosEstados();
    }

    @GET
    @Path("{id}")
    public Estados buscarEstado(@PathParam("id") long id) {
        return estadoDao.buscarEstado(id);
    }

    @POST
    public Estados criarEstado(Estados estado) {
        return estadoDao.criarEstado(estado);
    }

    @PUT
    public Estados atualizarEstado(Estados estado) {
        return estadoDao.atualizarEstado(estado);
    }

    @DELETE
    @Path("{id}")
    public void removerEstado(@PathParam("id") long id) {
        estadoDao.removerEstado(id);
    }

}
