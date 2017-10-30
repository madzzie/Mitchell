package util;

import org.junit.Test;
import pojo.Vehicle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VehicleRepositoryTest {
    VehicleRepository vehicleRepository = new VehicleRepository();

    @Test
    public void basic() {
        Vehicle vehicleById = vehicleRepository.getVehicleById(123);
        assertNotNull(vehicleById);
        assertEquals(123, vehicleById.getId());
    }

    @Test
    public void createVehicle() {
        Vehicle vehicle = vehicleRepository.createVehicle("Honda", "Civic", 2007);
        assertNotNull(vehicle);
        assertEquals(vehicleRepository.counter, vehicle.getId());
        assertEquals("Honda", vehicle.getMake());
        assertEquals("Civic", vehicle.getModel());
        assertEquals(2007, vehicle.getYear());
    }

    @Test
    public void getAllVehicles() {
        vehicleRepository.createVehicle("Honda", "Civic", 2007);
        vehicleRepository.createVehicle("Tata", "Nano", 2014);
        assertEquals(2, vehicleRepository.getAllVehicles().size());
    }
}
