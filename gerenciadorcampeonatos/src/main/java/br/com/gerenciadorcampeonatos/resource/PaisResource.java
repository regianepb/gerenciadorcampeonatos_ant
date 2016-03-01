package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.PaisDao;
import br.com.gerenciadorcampeonatos.modelo.Paises;
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

@Path("paises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaisResource {
    private PaisDao paisDao = new PaisDao();

    @GET
    public List<Paises> buscarTodosPaises() {
        return paisDao.buscarTodosPaises();
    }

    @GET
    @Path("{id}")
    public Paises buscarPais(@PathParam("id") long id) {
        return paisDao.buscarPais(id);
    }

    @POST
    public Paises criarPais(Paises pais) {
        return paisDao.criarPais(pais);
    }

    @PUT
    public Paises atualizarPais(Paises pais) {
        return paisDao.atualizarPais(pais);
    }

    @DELETE
    @Path("{id}")
    public void removerPais(@PathParam("id") long id) {
        paisDao.removerPais(id);
    }

}
