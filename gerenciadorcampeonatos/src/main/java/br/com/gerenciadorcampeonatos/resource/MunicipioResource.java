package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.MunicipioDao;
import br.com.gerenciadorcampeonatos.modelo.Municipios;
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

@Path("municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioResource {
    private MunicipioDao municipioDao = new MunicipioDao();

    @GET
    public List<Municipios> buscarTodosMunicipios() {
        return municipioDao.buscarTodosMunicipios();
    }

    @GET
    @Path("{id}")
    public Municipios buscarMunicipio(@PathParam("id") long id) {
        return municipioDao.buscarMunicipio(id);
    }

    @POST
    public Municipios criarMunicipio(Municipios municipio) {
        return municipioDao.criarMunicipio(municipio);
    }

    @PUT
    public Municipios atualizarMunicipio(Municipios municipio) {
        return municipioDao.atualizarMunicipio(municipio);
    }

    @DELETE
    @Path("{id}")
    public void removerMunicipio(@PathParam("id") long id) {
        municipioDao.removerMunicipio(id);
    }

}
