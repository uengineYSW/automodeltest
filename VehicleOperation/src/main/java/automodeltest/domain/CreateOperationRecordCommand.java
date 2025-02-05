package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOperationRecordCommand {

    private Long operationId;
    private Driver driver;
    private Date travelDate;
    private String departure;
    private String destination;
    private Double travelDistance;
    private TravelDuration travelDuration;
}
