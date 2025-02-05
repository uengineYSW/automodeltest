package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class MaintenanceHistoryQuery {

    private Long recordId;
    private String carId;
    private String maintenanceItem;
    private Date maintenanceDate;
    private String details;
}
