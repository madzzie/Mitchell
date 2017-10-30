package util;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import pojo.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class VehicleRepository {
    int counter = 0;
    private HashMap<Integer, Vehicle> cache = new HashMap<>();

    @Cacheable("vehicles")
    public Vehicle getVehicleById(int id) {
        Vehicle vehicle = new Vehicle(id, "abc", "def", 1234);
        cache.put(id, vehicle);
        return vehicle;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(cache.values());
    }

    public Vehicle getVehicle(int id) {
        return cache.get(id);
    }

    public void updateVehicle(int id, String make, String model, int year) {
        Vehicle vehicle = cache.get(id);
        if(vehicle != null) {
            vehicle.setMake(make);
            vehicle.setYear(year);
            vehicle.setModel(model);
        }
        cache.put(id, vehicle);
    }

    public Vehicle createVehicle(String make, String model, int year) {
        counter++;
        Vehicle vehicle = new Vehicle(counter, make, model, year);
        cache.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    public void deleteVehicle(int id) {
        cache.remove(id);
    }
}
