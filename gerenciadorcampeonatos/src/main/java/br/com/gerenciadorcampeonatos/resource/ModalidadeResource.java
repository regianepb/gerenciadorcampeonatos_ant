package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.ModalidadeDao;
import br.com.gerenciadorcampeonatos.modelo.Modalidades;
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

@Path("modalidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModalidadeResource {
    private ModalidadeDao modalidadeDao = new ModalidadeDao();

    @GET
    public List<Modalidades> buscarTodosModalidades() {
        return modalidadeDao.buscarTodasModalidades();
    }

    @GET
    @Path("{id}")
    public Modalidades buscarModalidade(@PathParam("id") long id) {
        return modalidadeDao.buscarModalidade(id);
    }

    @POST
    public Modalidades criarModalidade(Modalidades modalidade) {
        return modalidadeDao.criarModalidade(modalidade);
    }

    @PUT
    public Modalidades atualizarModalidade(Modalidades modalidade) {
        return modalidadeDao.atualizarModalidade(modalidade);
    }

    @DELETE
    @Path("{id}")
    public void removerModalidade(@PathParam("id") long id) {
        modalidadeDao.removerModalidade(id);
    }

}
