package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AssignmentRequestDetailsQuery {

    private Long requestId;
    private User user;
    private VehicleType vehicleType;
    private Date requestDate;
    private RequestStatus status;
}
