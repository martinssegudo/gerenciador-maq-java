package br.com.gerenciador.maq.usercases;

import br.com.gerenciador.maq.usercases.entities.Vehicle;
import br.com.gerenciador.maq.usercases.exceptions.UserCaseCreateException;

import java.util.List;

public interface VehicleUserCase {

    void createVehicle(Vehicle vehicle) throws UserCaseCreateException;
    Vehicle findByIdentification(String identification) throws UserCaseCreateException;
    List<Vehicle> findAll();
}
