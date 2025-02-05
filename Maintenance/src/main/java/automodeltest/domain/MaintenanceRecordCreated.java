package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MaintenanceRecordCreated extends AbstractEvent {

    private Long recordId;
    private String carId;
    private MaintenanceDetail maintenanceDetails;
    private Date maintenanceDate;
    private MaintenanceStatus status;

    public MaintenanceRecordCreated(MaintenanceRecord aggregate) {
        super(aggregate);
    }

    public MaintenanceRecordCreated() {
        super();
    }
}
//>>> DDD / Domain Event
