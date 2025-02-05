package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class OperationDetailsQuery {

    private Long summaryId;
    private SummaryMetrics summaryMetrics;
}
