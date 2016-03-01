package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.PosicaoDao;
import br.com.gerenciadorcampeonatos.modelo.Posicoes;
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

@Path("posicoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PosicaoResource {
    private PosicaoDao posicaoDao = new PosicaoDao();

    @GET
    public List<Posicoes> buscarTodosPosicoes() {
        return posicaoDao.buscarTodasPosicoes();
    }

    @GET
    @Path("{id}")
    public Posicoes buscarPosicao(@PathParam("id") long id) {
        return posicaoDao.buscarPosicao(id);
    }

    @POST
    public Posicoes criarPosicao(Posicoes time) {
        return posicaoDao.criarPosicao(time);
    }

    @PUT
    public Posicoes atualizarPosicao(Posicoes time) {
        return posicaoDao.atualizarPosicao(time);
    }

    @DELETE
    @Path("{id}")
    public void removerPosicao(@PathParam("id") long id) {
        posicaoDao.removerPosicao(id);
    }

}
