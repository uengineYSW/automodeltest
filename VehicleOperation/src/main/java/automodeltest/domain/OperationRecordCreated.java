package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OperationRecordCreated extends AbstractEvent {

    private Long operationId;
    private Driver driver;
    private Date travelDate;
    private String departure;
    private String destination;
    private Double travelDistance;
    private TravelDuration travelDuration;

    public OperationRecordCreated(OperationRecord aggregate) {
        super(aggregate);
    }

    public OperationRecordCreated() {
        super();
    }
}
//>>> DDD / Domain Event
