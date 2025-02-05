package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OperationRecordCreated extends AbstractEvent {

    private Long operationId;
    private Object driver;
    private Date travelDate;
    private String departure;
    private String destination;
    private Double travelDistance;
    private Object travelDuration;
}
