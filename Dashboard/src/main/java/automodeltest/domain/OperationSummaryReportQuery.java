package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OperationSummaryReportQuery {

    private Long summaryId;
    private Integer totalOperations;
    private Double totalDistance;
    private Double averageDistance;
}
