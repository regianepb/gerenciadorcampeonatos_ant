package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.DespesaDao;
import br.com.gerenciadorcampeonatos.modelo.Despesas;
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

@Path("despesas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DespesaResource {
    private DespesaDao despesaDao = new DespesaDao();

    @GET
    public List<Despesas> buscarTodosDespesas() {
        return despesaDao.buscarTodasDespesas();
    }

    @GET
    @Path("{id}")
    public Despesas buscarDespesa(@PathParam("id") long id) {
        return despesaDao.buscarDespesa(id);
    }

    @POST
    public Despesas criarDespesa(Despesas despesa) {
        return despesaDao.criarDespesa(despesa);
    }

    @PUT
    public Despesas atualizarDespesa(Despesas despesa) {
        return despesaDao.atualizarDespesa(despesa);
    }

    @DELETE
    @Path("{id}")
    public void removerDespesa(@PathParam("id") long id) {
        despesaDao.removerDespesa(id);
    }

}
