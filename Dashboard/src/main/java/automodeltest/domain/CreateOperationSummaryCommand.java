package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOperationSummaryCommand {

    private Long summaryId;
    private Integer totalOperations;
    private Double totalDistance;
    private Double averageDistance;
}
