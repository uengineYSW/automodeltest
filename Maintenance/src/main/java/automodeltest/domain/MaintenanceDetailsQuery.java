package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class MaintenanceDetailsQuery {

    private Long recordId;
    private String carId;
    private MaintenanceDetail maintenanceDetails;
    private Date maintenanceDate;
    private MaintenanceStatus status;
}
