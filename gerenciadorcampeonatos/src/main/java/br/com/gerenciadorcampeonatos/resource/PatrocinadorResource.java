package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.PatrocinadorDao;
import br.com.gerenciadorcampeonatos.modelo.Patrocinadores;
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

@Path("patrocinadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatrocinadorResource {
    private PatrocinadorDao patrocinadorDao = new PatrocinadorDao();

    @GET
    public List<Patrocinadores> buscarTodosPatrocinadores() {
        return patrocinadorDao.buscarTodosPatrocinadores();
    }

    @GET
    @Path("{id}")
    public Patrocinadores buscarPatrocinador(@PathParam("id") long id) {
        return patrocinadorDao.buscarPatrocinador(id);
    }

    @POST
    public Patrocinadores criarPatrocinador(Patrocinadores patrocinador) {
        return patrocinadorDao.criarPatrocinador(patrocinador);
    }

    @PUT
    public Patrocinadores atualizarPatrocinador(Patrocinadores patrocinador) {
        return patrocinadorDao.atualizarPatrocinador(patrocinador);
    }

    @DELETE
    @Path("{id}")
    public void removerPatrocinador(@PathParam("id") long id) {
        patrocinadorDao.removerPatrocinador(id);
    }

}
