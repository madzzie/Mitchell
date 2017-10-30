package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import util.VehicleRepository;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final VehicleRepository vehicleRepository;

    public AppRunner(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching Vehicles");
        logger.info("1 -->" + vehicleRepository.getVehicleById(1876));
        logger.info("2 -->" + vehicleRepository.getVehicleById(22343));
        logger.info("3 -->" + vehicleRepository.getVehicleById(30923));
        logger.info("4 -->" + vehicleRepository.getVehicleById(423));
        logger.info("5 -->" + vehicleRepository.getVehicleById(599));
        logger.info("6 -->" + vehicleRepository.getVehicleById(622));
    }
}