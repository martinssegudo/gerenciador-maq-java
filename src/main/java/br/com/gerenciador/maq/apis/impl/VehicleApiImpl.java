package br.com.gerenciador.maq.apis.impl;

import br.com.gerenciador.maq.apis.VehicleApi;
import br.com.gerenciador.maq.apis.dtos.VehicleDTO;
import br.com.gerenciador.maq.mappers.VehicleMapper;
import br.com.gerenciador.maq.usercases.VehicleUserCase;
import br.com.gerenciador.maq.usercases.exceptions.UserCaseCreateException;
import br.com.gerenciador.maq.usercases.impl.VehicleUserCaseImpl;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
@Tag(name = "Vehicle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleApiImpl implements VehicleApi {



    private VehicleMapper vehicleMapper;

    private VehicleUserCase vehicleUserCase;

    @Inject
    public VehicleApiImpl(VehicleMapper vehicleMapper){
        this.vehicleMapper = vehicleMapper;
        this.vehicleUserCase = new VehicleUserCaseImpl(vehicleMapper);
    }

    @POST
    @Transactional
    @Override
    public Response createVehicle(VehicleDTO vehicleDTO) {
        try {
            vehicleUserCase.createVehicle(vehicleMapper.convertToVehicleDTO(vehicleDTO));
        } catch (UserCaseCreateException e) {
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{ident}")
    @Override
    public Response findByIdentification(@PathParam("ident") String identification) {
        try {
            VehicleDTO dto = vehicleMapper.converToDTO(vehicleUserCase.findByIdentification(identification));
            return Response.ok(dto).build();
        } catch (UserCaseCreateException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @GET
    @Override
    public Response findALl() {
        return Response.ok(vehicleUserCase.findAll()).build();
    }

}
