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
@Table(name = "MaintenanceRecord_table")
@Data
//<<< DDD / Aggregate Root
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    private String carId;

    @Embedded
    private MaintenanceDetail maintenanceDetails;

    private Date maintenanceDate;

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;

    private Car car;

    @Embedded
    private OperationRecordId operationRecordId;

    public static MaintenanceRecordRepository repository() {
        MaintenanceRecordRepository maintenanceRecordRepository = MaintenanceApplication.applicationContext.getBean(
            MaintenanceRecordRepository.class
        );
        return maintenanceRecordRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerMaintenance(
        RegisterMaintenanceCommand registerMaintenanceCommand
    ) {
        //implement business logic here:

        MaintenanceRecordCreated maintenanceRecordCreated = new MaintenanceRecordCreated(
            this
        );
        maintenanceRecordCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
