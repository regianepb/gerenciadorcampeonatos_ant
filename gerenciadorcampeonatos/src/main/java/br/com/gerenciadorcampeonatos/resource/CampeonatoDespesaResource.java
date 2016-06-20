package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.CampeonatoDespesaDao;
import br.com.gerenciadorcampeonatos.modelo.CampeonatosDespesas;
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

@Path("campeonatosdespesas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CampeonatoDespesaResource {
    private CampeonatoDespesaDao campeonatoDespesaDao = new CampeonatoDespesaDao();

    @GET
    public List<CampeonatosDespesas> buscarTodosCampeonatosDespesas() {
        return campeonatoDespesaDao.buscarTodosCampeonatosDespesas();
    }

    @GET
    @Path("{id}")
    public CampeonatosDespesas buscarCampeonatoDespesa(@PathParam("id") long id) {
        return campeonatoDespesaDao.buscarCampeonatoDespesa(id);
    }

    @POST
    public CampeonatosDespesas criarCampeonatoDespesa(CampeonatosDespesas campeonatoDespesa) {
        return campeonatoDespesaDao.criarCampeonatoDespesa(campeonatoDespesa);
    }

    @PUT
    @Path("{id}")
    public CampeonatosDespesas atualizarCampeonato(CampeonatosDespesas campeonatoDespesa) {
        return campeonatoDespesaDao.atualizarCampeonatoDespesa(campeonatoDespesa);
    }

    @DELETE
    @Path("{id}")
    public void removerCampeonatoDespesa(@PathParam("id") long id) {
        campeonatoDespesaDao.removerCampeonatoDespesa(id);
    }

}

