package automodeltest.domain;

import automodeltest.DashboardApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DashboardMetrics_table")
@Data
//<<< DDD / Aggregate Root
public class DashboardMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private OperationSummaryId operationSummaryId;

    public static DashboardMetricsRepository repository() {
        DashboardMetricsRepository dashboardMetricsRepository = DashboardApplication.applicationContext.getBean(
            DashboardMetricsRepository.class
        );
        return dashboardMetricsRepository;
    }
}
//>>> DDD / Aggregate Root
