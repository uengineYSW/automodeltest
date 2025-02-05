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
// @RequestMapping(value="/operationRecords")
@Transactional
public class OperationRecordController {

    @Autowired
    OperationRecordRepository operationRecordRepository;

    @RequestMapping(
        value = "/operationRecords",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public OperationRecord createOperationRecord(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateOperationRecordCommand createOperationRecordCommand
    ) throws Exception {
        System.out.println(
            "##### /operationRecord/createOperationRecord  called #####"
        );
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.createOperationRecord(createOperationRecordCommand);
        operationRecordRepository.save(operationRecord);
        return operationRecord;
    }
}
//>>> Clean Arch / Inbound Adaptor
