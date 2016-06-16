package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.CampeonatoDao;
import br.com.gerenciadorcampeonatos.modelo.Campeonatos;
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

@Path("campeonatos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CampeonatoResource {
    private CampeonatoDao campeonatoDao = new CampeonatoDao();

    @GET
    public List<Campeonatos> buscarTodosCampeonatos() {
        return campeonatoDao.buscarTodosCampeonatos();
    }

    @GET
    @Path("{id}")
    public Campeonatos buscarCampeonato(@PathParam("id") long id) {
        return campeonatoDao.buscarCampeonato(id);
    }

    @POST
    public Campeonatos criarCampeonato(Campeonatos campeonato) {
        return campeonatoDao.criarCampeonato(campeonato);
    }

    @PUT
    @Path("{id}")
    public Campeonatos atualizarCampeonato(Campeonatos campeonato) {
        return campeonatoDao.atualizarCampeonato(campeonato);
    }

    @DELETE
    @Path("{id}")
    public void removerCampeonato(@PathParam("id") long id) {
        campeonatoDao.removerCampeonato(id);
    }

}

