package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.BairroDao;
import br.com.gerenciadorcampeonatos.modelo.Bairros;
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

@Path("bairros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BairroResource {
    private BairroDao bairroDao = new BairroDao();

    @GET
    public List<Bairros> buscarTodosBairros() {
        return bairroDao.buscarTodosBairros();
    }

    @GET
    @Path("{id}")
    public Bairros buscarBairro(@PathParam("id") long id) {
        return bairroDao.buscarBairro(id);
    }

    @POST
    public Bairros criarBairro(Bairros bairro) {
        return bairroDao.criarBairro(bairro);
    }

    @PUT
    public Bairros atualizarBairro(Bairros bairro) {
        return bairroDao.atualizarBairro(bairro);
    }

    @DELETE
    @Path("{id}")
    public void removerBairro(@PathParam("id") long id) {
        bairroDao.removerBairro(id);
    }

}
