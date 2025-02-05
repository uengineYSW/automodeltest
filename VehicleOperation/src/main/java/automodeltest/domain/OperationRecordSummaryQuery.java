package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OperationRecordSummaryQuery {

    private Long operationId;
    private Driver driver;
    private Date travelDate;
    private String departure;
    private String destination;
    private Double travelDistance;
    private TravelDuration travelDuration;
}
