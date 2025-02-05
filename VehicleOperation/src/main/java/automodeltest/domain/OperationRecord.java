package automodeltest.domain;

import automodeltest.VehicleOperationApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OperationRecord_table")
@Data
//<<< DDD / Aggregate Root
public class OperationRecord {

    @Id
    private String operationId;

    @Embedded
    private Driver driver;

    @Embedded
    private Vehicle vehicle;

    private Double travelDistance;

    private Date travelDate;

    private String departure;

    private String destination;

    public static OperationRecordRepository repository() {
        OperationRecordRepository operationRecordRepository = VehicleOperationApplication.applicationContext.getBean(
            OperationRecordRepository.class
        );
        return operationRecordRepository;
    }

    //<<< Clean Arch / Port Method
    public void createOperationRecord(
        CreateOperationRecordCommand createOperationRecordCommand
    ) {
        //implement business logic here:

        OperationRecordCreated operationRecordCreated = new OperationRecordCreated(
            this
        );
        operationRecordCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
