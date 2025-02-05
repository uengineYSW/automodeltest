package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OperationSummaryCreated extends AbstractEvent {

    private Long summaryId;
    private Integer totalOperations;
    private Double totalDistance;
    private Double averageDistance;

    public OperationSummaryCreated(OperationSummary aggregate) {
        super(aggregate);
    }

    public OperationSummaryCreated() {
        super();
    }
}
//>>> DDD / Domain Event
