package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AssignmentRequestCreated extends AbstractEvent {

    private Long requestId;
    private Long userId;
    private VehicleType vehicleType;
    private Date requestDate;
    private RequestStatus status;

    public AssignmentRequestCreated(AssignmentRequest aggregate) {
        super(aggregate);
    }

    public AssignmentRequestCreated() {
        super();
    }
}
//>>> DDD / Domain Event
