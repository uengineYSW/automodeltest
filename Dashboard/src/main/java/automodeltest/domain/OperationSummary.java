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
@Table(name = "OperationSummary_table")
@Data
//<<< DDD / Aggregate Root
public class OperationSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long summaryId;

    @Embedded
    private SummaryMetrics summaryMetrics;

    public static OperationSummaryRepository repository() {
        OperationSummaryRepository operationSummaryRepository = DashboardApplication.applicationContext.getBean(
            OperationSummaryRepository.class
        );
        return operationSummaryRepository;
    }

    //<<< Clean Arch / Port Method
    public void createOperationSummary(
        CreateOperationSummaryCommand createOperationSummaryCommand
    ) {
        //implement business logic here:

        OperationSummaryCreated operationSummaryCreated = new OperationSummaryCreated(
            this
        );
        operationSummaryCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
