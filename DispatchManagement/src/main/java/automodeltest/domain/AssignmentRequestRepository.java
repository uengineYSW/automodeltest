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
    collectionResourceRel = "assignmentRequests",
    path = "assignmentRequests"
)
public interface AssignmentRequestRepository
    extends PagingAndSortingRepository<AssignmentRequest, Long> {
    @Query(
        value = "select assignmentRequest " +
        "from AssignmentRequest assignmentRequest " +
        "where(:requestId is null or assignmentRequest.requestId = :requestId) and (:vehicleType is null or assignmentRequest.vehicleType = :vehicleType) and (:requestDate is null or assignmentRequest.requestDate = :requestDate) and (:status is null or assignmentRequest.status = :status)"
    )
    List<AssignmentRequest> assignmentRequestSummary(
        Long requestId,
        VehicleType vehicleType,
        Date requestDate,
        RequestStatus status,
        Pageable pageable
    );

    @Query(
        value = "select assignmentRequest " +
        "from AssignmentRequest assignmentRequest " +
        "where(:requestId is null or assignmentRequest.requestId = :requestId) and (:user is null or assignmentRequest.user = :user) and (:vehicleType is null or assignmentRequest.vehicleType = :vehicleType) and (:requestDate is null or assignmentRequest.requestDate = :requestDate) and (:status is null or assignmentRequest.status = :status)"
    )
    AssignmentRequest assignmentRequestDetails(
        Long requestId,
        User user,
        VehicleType vehicleType,
        Date requestDate,
        RequestStatus status
    );
}
