package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.JogadorDao;
import br.com.gerenciadorcampeonatos.modelo.Jogadores;
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

@Path("jogadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorResource {
    private JogadorDao jogadorDao = new JogadorDao();

    @GET
    public List<Jogadores> buscarTodosJogadors() {
        return jogadorDao.buscarTodosJogadores();
    }

    @GET
    @Path("{id}")
    public Jogadores buscarJogador(@PathParam("id") long id) {
        return jogadorDao.buscarJogador(id);
    }

    @POST
    public Jogadores criarJogador(Jogadores time) {
        return jogadorDao.criarJogador(time);
    }

    @PUT
    public Jogadores atualizarJogador(Jogadores time) {
        return jogadorDao.atualizarJogador(time);
    }

    @DELETE
    @Path("{id}")
    public void removerJogador(@PathParam("id") long id) {
        jogadorDao.removerJogador(id);
    }

}

