package automodeltest.domain;

import automodeltest.MaintenanceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Vehicle_table")
@Data
//<<< DDD / Aggregate Root
public class Vehicle {

    @Id
    private String vehicleId;

    @Embedded
    private CarDetail carDetail;

    private String licensePlate;

    private String ownerName;

    public static VehicleRepository repository() {
        VehicleRepository vehicleRepository = MaintenanceApplication.applicationContext.getBean(
            VehicleRepository.class
        );
        return vehicleRepository;
    }
}
//>>> DDD / Aggregate Root
