package automodeltest.domain;

import automodeltest.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "operationSummaries",
    path = "operationSummaries"
)
public interface OperationSummaryRepository
    extends PagingAndSortingRepository<OperationSummary, Long> {
    @Query(
        value = "select operationSummary " +
        "from OperationSummary operationSummary " +
        "where(:summaryId is null or operationSummary.summaryId = :summaryId) and (:totalOperations is null or operationSummary.totalOperations = :totalOperations) and (:totalDistance is null or operationSummary.totalDistance = :totalDistance) and (:averageDistance is null or operationSummary.averageDistance = :averageDistance)"
    )
    List<OperationSummary> operationSummaryReport(
        Long summaryId,
        Integer totalOperations,
        Double totalDistance,
        Double averageDistance,
        Pageable pageable
    );

    @Query(
        value = "select operationSummary " +
        "from OperationSummary operationSummary " +
        "where(:summaryId is null or operationSummary.summaryId = :summaryId) and (:summaryMetrics is null or operationSummary.summaryMetrics = :summaryMetrics)"
    )
    OperationSummary operationDetails(
        Long summaryId,
        SummaryMetrics summaryMetrics
    );
}
