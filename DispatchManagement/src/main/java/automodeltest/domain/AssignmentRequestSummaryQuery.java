package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AssignmentRequestSummaryQuery {

    private Long requestId;
    private VehicleType vehicleType;
    private Date requestDate;
    private RequestStatus status;
}
