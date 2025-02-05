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
// @RequestMapping(value="/maintenanceRecords")
@Transactional
public class MaintenanceRecordController {

    @Autowired
    MaintenanceRecordRepository maintenanceRecordRepository;

    @RequestMapping(
        value = "/maintenanceRecords",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public MaintenanceRecord registerMaintenance(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterMaintenanceCommand registerMaintenanceCommand
    ) throws Exception {
        System.out.println(
            "##### /maintenanceRecord/registerMaintenance  called #####"
        );
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        maintenanceRecord.registerMaintenance(registerMaintenanceCommand);
        maintenanceRecordRepository.save(maintenanceRecord);
        return maintenanceRecord;
    }
}
//>>> Clean Arch / Inbound Adaptor
