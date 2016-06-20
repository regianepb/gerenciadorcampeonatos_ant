package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.CampeonatoPatrocinadorDao;
import br.com.gerenciadorcampeonatos.modelo.CampeonatosPatrocinadores;
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

@Path("campeonatospatrocinadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CampeonatoPatrocinadorResource {
    private CampeonatoPatrocinadorDao campeonatoPatrocinadorDao = new CampeonatoPatrocinadorDao();

    @GET
    public List<CampeonatosPatrocinadores> buscarTodosCampeonatosPatrocinadores() {
        return campeonatoPatrocinadorDao.buscarTodosCampeonatosPatrocinadores();
    }

    @GET
    @Path("{id}")
    public CampeonatosPatrocinadores buscarCampeonatoPatrocinador(@PathParam("id") long id) {
        return campeonatoPatrocinadorDao.buscarCampeonatoPatrocinador(id);
    }

    @POST
    public CampeonatosPatrocinadores criarCampeonatoPatrocinador(CampeonatosPatrocinadores campeonatoPatrocinador) {
        return campeonatoPatrocinadorDao.criarCampeonatoPatrocinador(campeonatoPatrocinador);
    }

    @PUT
    @Path("{id}")
    public CampeonatosPatrocinadores atualizarCampeonato(CampeonatosPatrocinadores campeonatoPatrocinador) {
        return campeonatoPatrocinadorDao.atualizarCampeonatoPatrocinador(campeonatoPatrocinador);
    }

    @DELETE
    @Path("{id}")
    public void removerCampeonatoPatrocinador(@PathParam("id") long id) {
        campeonatoPatrocinadorDao.removerCampeonatoPatrocinador(id);
    }

}

