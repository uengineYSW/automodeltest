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
    collectionResourceRel = "operationRecords",
    path = "operationRecords"
)
public interface OperationRecordRepository
    extends PagingAndSortingRepository<OperationRecord, String> {
    @Query(
        value = "select operationRecord " +
        "from OperationRecord operationRecord " +
        "where(:operationId is null or operationRecord.operationId = :operationId) and (:driver is null or operationRecord.driver = :driver) and (:travelDate is null or operationRecord.travelDate = :travelDate) and (:departure is null or operationRecord.departure like %:departure%) and (:destination is null or operationRecord.destination like %:destination%) and (:travelDistance is null or operationRecord.travelDistance = :travelDistance) and (:travelDuration is null or operationRecord.travelDuration = :travelDuration)"
    )
    List<OperationRecord> operationRecordSummary(
        Long operationId,
        Driver driver,
        Date travelDate,
        String departure,
        String destination,
        Double travelDistance,
        TravelDuration travelDuration,
        Pageable pageable
    );

    @Query(
        value = "select operationRecord " +
        "from OperationRecord operationRecord " +
        "where(:operationId is null or operationRecord.operationId = :operationId) and (:driver is null or operationRecord.driver = :driver) and (:travelDate is null or operationRecord.travelDate = :travelDate) and (:departure is null or operationRecord.departure like %:departure%) and (:destination is null or operationRecord.destination like %:destination%) and (:travelDistance is null or operationRecord.travelDistance = :travelDistance) and (:travelDuration is null or operationRecord.travelDuration = :travelDuration)"
    )
    OperationRecord operationRecordDetails(
        Long operationId,
        Driver driver,
        Date travelDate,
        String departure,
        String destination,
        Double travelDistance,
        TravelDuration travelDuration
    );
}
