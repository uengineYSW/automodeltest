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
    collectionResourceRel = "maintenanceRecords",
    path = "maintenanceRecords"
)
public interface MaintenanceRecordRepository
    extends PagingAndSortingRepository<MaintenanceRecord, Long> {
    @Query(
        value = "select maintenanceRecord " +
        "from MaintenanceRecord maintenanceRecord " +
        "where(:recordId is null or maintenanceRecord.recordId = :recordId) and (:carId is null or maintenanceRecord.carId like %:carId%) and (:maintenanceItem is null or maintenanceRecord.maintenanceItem like %:maintenanceItem%) and (:maintenanceDate is null or maintenanceRecord.maintenanceDate = :maintenanceDate) and (:details is null or maintenanceRecord.details like %:details%)"
    )
    List<MaintenanceRecord> maintenanceHistory(
        Long recordId,
        String carId,
        String maintenanceItem,
        Date maintenanceDate,
        String details,
        Pageable pageable
    );

    @Query(
        value = "select maintenanceRecord " +
        "from MaintenanceRecord maintenanceRecord " +
        "where(:recordId is null or maintenanceRecord.recordId = :recordId) and (:carId is null or maintenanceRecord.carId like %:carId%) and (:maintenanceDetails is null or maintenanceRecord.maintenanceDetails = :maintenanceDetails) and (:maintenanceDate is null or maintenanceRecord.maintenanceDate = :maintenanceDate) and (:status is null or maintenanceRecord.status = :status)"
    )
    MaintenanceRecord maintenanceDetails(
        Long recordId,
        String carId,
        MaintenanceDetail maintenanceDetails,
        Date maintenanceDate,
        MaintenanceStatus status
    );
}
