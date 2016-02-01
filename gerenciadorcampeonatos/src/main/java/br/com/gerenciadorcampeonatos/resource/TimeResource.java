package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dto.TimeDto;
import br.com.gerenciadorcampeonatos.mappers.TimeMapper;
import br.com.gerenciadorcampeonatos.service.TimeService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("times")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class TimeResource {

    @Inject
    TimeService timeService;
    
    @POST
    public Response create(final TimeDto dto) {
        timeService.persist(TimeMapper.toEntity(dto));
        return Response.created(null).build();
    }

    
    
}
