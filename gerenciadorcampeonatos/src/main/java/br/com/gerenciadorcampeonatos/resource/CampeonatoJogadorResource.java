package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.CampeonatoJogadorDao;
import br.com.gerenciadorcampeonatos.modelo.CampeonatosJogadores;
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

@Path("campeonatosjogadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CampeonatoJogadorResource {
    private CampeonatoJogadorDao campeonatoJogadorDao = new CampeonatoJogadorDao();

    @GET
    public List<CampeonatosJogadores> buscarTodosCampeonatosJogadores() {
        return campeonatoJogadorDao.buscarTodosCampeonatosJogadores();
    }

    @GET
    @Path("{id}")
    public CampeonatosJogadores buscarCampeonatoJogador(@PathParam("id") long id) {
        return campeonatoJogadorDao.buscarCampeonatoJogador(id);
    }

    @POST
    public CampeonatosJogadores criarCampeonatoJogador(CampeonatosJogadores campeonatoJogador) {
        return campeonatoJogadorDao.criarCampeonatoJogador(campeonatoJogador);
    }

    @PUT
    @Path("{id}")
    public CampeonatosJogadores atualizarCampeonato(CampeonatosJogadores campeonatoJogador) {
        return campeonatoJogadorDao.atualizarCampeonatoJogador(campeonatoJogador);
    }

    @DELETE
    @Path("{id}")
    public void removerCampeonatoJogador(@PathParam("id") long id) {
        campeonatoJogadorDao.removerCampeonatoJogador(id);
    }

}

