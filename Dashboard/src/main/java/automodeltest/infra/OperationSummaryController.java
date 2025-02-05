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
// @RequestMapping(value="/operationSummaries")
@Transactional
public class OperationSummaryController {

    @Autowired
    OperationSummaryRepository operationSummaryRepository;

    @RequestMapping(
        value = "/operationSummaries",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public OperationSummary createOperationSummary(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateOperationSummaryCommand createOperationSummaryCommand
    ) throws Exception {
        System.out.println(
            "##### /operationSummary/createOperationSummary  called #####"
        );
        OperationSummary operationSummary = new OperationSummary();
        operationSummary.createOperationSummary(createOperationSummaryCommand);
        operationSummaryRepository.save(operationSummary);
        return operationSummary;
    }
}
//>>> Clean Arch / Inbound Adaptor
