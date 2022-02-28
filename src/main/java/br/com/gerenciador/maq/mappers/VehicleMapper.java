package br.com.gerenciador.maq.mappers;

import br.com.gerenciador.maq.apis.dtos.VehicleDTO;
import br.com.gerenciador.maq.db.entities.VehicleEntity;
import br.com.gerenciador.maq.usercases.entities.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface VehicleMapper {

    VehicleEntity converToVehicle(Vehicle vehicle);

    Vehicle convertToVehicleEntity(VehicleEntity vehicleEntity);

    Vehicle convertToVehicleDTO(VehicleDTO dto);

    VehicleDTO converToDTO(Vehicle vehicle);

    List<Vehicle> converToListDTO(List<VehicleEntity> list);
}
