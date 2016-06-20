package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.JogadorPosicaoDao;
import br.com.gerenciadorcampeonatos.modelo.JogadoresPosicoes;
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

@Path("jogadoresposicoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorPosicaoResource {
    private JogadorPosicaoDao municipioDao = new JogadorPosicaoDao();

    @GET
    public List<JogadoresPosicoes> buscarTodosJogadoresPosicoes() {
        return municipioDao.buscarTodosJogadoresPosicoes();
    }

    @GET
    @Path("{id}")
    public JogadoresPosicoes buscarJogadorPosicao(@PathParam("id") long id) {
        return municipioDao.buscarJogadorPosicao(id);
    }

    @POST
    public JogadoresPosicoes criarJogadorPosicao(JogadoresPosicoes municipio) {
        return municipioDao.criarJogadorPosicao(municipio);
    }

    @PUT
    public JogadoresPosicoes atualizarJogadorPosicao(JogadoresPosicoes municipio) {
        return municipioDao.atualizarJogadorPosicao(municipio);
    }

    @DELETE
    @Path("{id}")
    public void removerJogadorPosicao(@PathParam("id") long id) {
        municipioDao.removerJogadorPosicao(id);
    }

}
