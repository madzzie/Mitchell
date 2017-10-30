package controller;

import org.springframework.web.bind.annotation.*;
import pojo.Vehicle;
import util.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleRepository vehicleRepository;
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> vehicles() {
        return vehicleRepository.getAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Vehicle vehiclesWithId(@RequestParam(value="id") int id) {
        return vehicleRepository.getVehicle(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createVehicles(@RequestParam(value = "make") String make,
                                 @RequestParam(value = "model") String model,
                                 @RequestParam(value = "year") int year) {
        Vehicle vehicle = vehicleRepository.createVehicle(make, model, year);
        return "Vehicle: " + vehicle;
    }

    @RequestMapping(method=RequestMethod.POST, value = "/{id}")
    public String updateVehicles(@RequestParam(value = "make") String make,
                                 @RequestParam(value = "model") String model,
                                 @RequestParam(value = "year") int year,
                                 @RequestParam(value = "id") int id) {
        vehicleRepository.updateVehicle(id, make, model, year);
        return "Update Vehicle";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteVehicles(@RequestParam(value="id") int id) {
        vehicleRepository.deleteVehicle(id);
        return "Deleted Vehicle: " + id;
    }

}
