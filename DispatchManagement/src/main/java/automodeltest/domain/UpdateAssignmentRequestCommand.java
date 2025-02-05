package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateAssignmentRequestCommand {

    private Long requestId;
    private VehicleType vehicleType;
    private Date requestDate;
}
