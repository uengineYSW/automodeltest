package automodeltest.infra;

import automodeltest.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/assignmentRequests")
@Transactional
public class AssignmentRequestController {

    @Autowired
    AssignmentRequestRepository assignmentRequestRepository;

    @RequestMapping(
        value = "/assignmentRequests",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public AssignmentRequest createAssignmentRequest(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateAssignmentRequestCommand createAssignmentRequestCommand
    ) throws Exception {
        System.out.println(
            "##### /assignmentRequest/createAssignmentRequest  called #####"
        );
        AssignmentRequest assignmentRequest = new AssignmentRequest();
        assignmentRequest.createAssignmentRequest(
            createAssignmentRequestCommand
        );
        assignmentRequestRepository.save(assignmentRequest);
        return assignmentRequest;
    }

    @RequestMapping(
        value = "/assignmentRequests/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public AssignmentRequest updateAssignmentRequest(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateAssignmentRequestCommand updateAssignmentRequestCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /assignmentRequest/updateAssignmentRequest  called #####"
        );
        Optional<AssignmentRequest> optionalAssignmentRequest = assignmentRequestRepository.findById(
            id
        );

        optionalAssignmentRequest.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        AssignmentRequest assignmentRequest = optionalAssignmentRequest.get();
        assignmentRequest.updateAssignmentRequest(
            updateAssignmentRequestCommand
        );

        assignmentRequestRepository.save(assignmentRequest);
        return assignmentRequest;
    }

    @RequestMapping(
        value = "/assignmentRequests/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public AssignmentRequest cancelAssignmentRequest(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelAssignmentRequestCommand cancelAssignmentRequestCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /assignmentRequest/cancelAssignmentRequest  called #####"
        );
        Optional<AssignmentRequest> optionalAssignmentRequest = assignmentRequestRepository.findById(
            id
        );

        optionalAssignmentRequest.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        AssignmentRequest assignmentRequest = optionalAssignmentRequest.get();
        assignmentRequest.cancelAssignmentRequest(
            cancelAssignmentRequestCommand
        );

        assignmentRequestRepository.save(assignmentRequest);
        return assignmentRequest;
    }
}
//>>> Clean Arch / Inbound Adaptor
