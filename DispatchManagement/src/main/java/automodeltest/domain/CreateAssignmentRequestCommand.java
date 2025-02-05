package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateAssignmentRequestCommand {

    private Long requestId;
    private Long userId;
    private VehicleType vehicleType;
    private Date requestDate;
    private RequestStatus status;
}
