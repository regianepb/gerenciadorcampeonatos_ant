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
public class PatrocinadorResource {
    private PatrocinadorDao patrocinadorDao = new PatrocinadorDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Patrocinadores> buscarTodosPatrocinadores() {
        return patrocinadorDao.buscarTodosPatrocinadores();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Patrocinadores buscarPatrocinador(@PathParam("id") long id) {
        return patrocinadorDao.buscarPatrocinador(id);
    }

    @POST    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Patrocinadores criarPatrocinador(Patrocinadores patrocinador) {
        return patrocinadorDao.criarPatrocinador(patrocinador);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Patrocinadores atualizarPatrocinador(Patrocinadores patrocinador) {
        return patrocinadorDao.atualizarPatrocinador(patrocinador);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removerPatrocinador(@PathParam("id") long id) {
        patrocinadorDao.removerPatrocinador(id);
    }

}
