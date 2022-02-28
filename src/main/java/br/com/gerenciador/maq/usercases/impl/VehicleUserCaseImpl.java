package br.com.gerenciador.maq.usercases.impl;

import br.com.gerenciador.maq.db.entities.VehicleEntity;
import br.com.gerenciador.maq.mappers.VehicleMapper;
import br.com.gerenciador.maq.usercases.VehicleUserCase;
import br.com.gerenciador.maq.usercases.entities.Vehicle;
import br.com.gerenciador.maq.usercases.exceptions.UserCaseCreateException;

import java.util.List;

public class VehicleUserCaseImpl implements VehicleUserCase {

    private VehicleMapper vehicleMapper;

    public VehicleUserCaseImpl(VehicleMapper vehicleMapper){
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public void createVehicle(Vehicle vehicle) throws UserCaseCreateException {
        vehicleMapper.converToVehicle(vehicle).persist();
    }

    @Override
    public Vehicle findByIdentification(String identification) throws UserCaseCreateException {
        return vehicleMapper.convertToVehicleEntity(
                VehicleEntity.findByIdentification(identification)
                        .orElseThrow(UserCaseCreateException::new)
        );
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleMapper.converToListDTO(VehicleEntity.findAll().list());
    }
}
