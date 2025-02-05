package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AssignmentRequestCancelled extends AbstractEvent {

    private Long requestId;
    private String cancellationReason;
    private Date cancelledAt;

    public AssignmentRequestCancelled(AssignmentRequest aggregate) {
        super(aggregate);
    }

    public AssignmentRequestCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
