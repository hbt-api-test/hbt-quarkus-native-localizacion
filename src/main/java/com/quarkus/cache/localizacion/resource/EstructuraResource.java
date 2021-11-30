package com.quarkus.cache.localizacion.resource;


import com.quarkus.cache.localizacion.model.entity.EstructuraDTO;
import com.quarkus.cache.localizacion.model.entity.EstructuraGeografica;
import com.quarkus.cache.localizacion.model.entity.ResponseData;
import com.quarkus.cache.localizacion.model.service.interfaces.IEstructuraService;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.springframework.http.HttpStatus;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Path("/api")
@Slf4j
public class EstructuraResource {

    @Inject
    IEstructuraService estructuraService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EstructuraGeografica> findAll(){
        return estructuraService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseData<List<EstructuraDTO>> findByIdNivel(@PathParam Long id){
        log.info("ID: " + id);
        Long timeSeconds = System.currentTimeMillis() ;

        ResponseData<List<EstructuraDTO>> responseData = new ResponseData<>();
        List<EstructuraDTO> respuesta = estructuraService.findByIdNivel(id);
        responseData.setCount(respuesta.size());
        responseData.setMessage("Datos obtenidos");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(respuesta);
        responseData.setTimestamp(ZonedDateTime.now(ZoneId.of("Z")));

        Long finalTime = System.currentTimeMillis() ;

        finalTime = finalTime - timeSeconds;

        responseData.setTimeExecution(finalTime);

        return responseData;
    }

}
