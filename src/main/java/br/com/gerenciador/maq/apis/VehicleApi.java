package br.com.gerenciador.maq.apis;

import br.com.gerenciador.maq.apis.dtos.VehicleDTO;

import javax.ws.rs.core.Response;


public interface VehicleApi {

    Response createVehicle(VehicleDTO vehicleDTO);
    Response findByIdentification(String identification);
    Response findALl();
}
