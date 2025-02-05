package automodeltest.domain;

import automodeltest.DispatchManagementApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AssignmentRequest_table")
@Data
//<<< DDD / Aggregate Root
public class AssignmentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;

    @Embedded
    private User user;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Date requestDate;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    public static AssignmentRequestRepository repository() {
        AssignmentRequestRepository assignmentRequestRepository = DispatchManagementApplication.applicationContext.getBean(
            AssignmentRequestRepository.class
        );
        return assignmentRequestRepository;
    }

    //<<< Clean Arch / Port Method
    public void createAssignmentRequest(
        CreateAssignmentRequestCommand createAssignmentRequestCommand
    ) {
        //implement business logic here:

        AssignmentRequestCreated assignmentRequestCreated = new AssignmentRequestCreated(
            this
        );
        assignmentRequestCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateAssignmentRequest(
        UpdateAssignmentRequestCommand updateAssignmentRequestCommand
    ) {
        //implement business logic here:

        AssignmentRequestUpdated assignmentRequestUpdated = new AssignmentRequestUpdated(
            this
        );
        assignmentRequestUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelAssignmentRequest(
        CancelAssignmentRequestCommand cancelAssignmentRequestCommand
    ) {
        //implement business logic here:

        AssignmentRequestCancelled assignmentRequestCancelled = new AssignmentRequestCancelled(
            this
        );
        assignmentRequestCancelled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
