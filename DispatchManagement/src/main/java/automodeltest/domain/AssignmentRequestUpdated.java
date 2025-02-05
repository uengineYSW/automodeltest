package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AssignmentRequestUpdated extends AbstractEvent {

    private Long requestId;
    private VehicleType vehicleType;
    private Date requestDate;

    public AssignmentRequestUpdated(AssignmentRequest aggregate) {
        super(aggregate);
    }

    public AssignmentRequestUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
