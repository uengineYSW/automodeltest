package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterMaintenanceCommand {

    private Long recordId;
    private String carId;
    private MaintenanceDetail maintenanceDetails;
    private Date maintenanceDate;
    private MaintenanceStatus status;
}
