package automodeltest.infra;

import automodeltest.config.kafka.KafkaProcessor;
import automodeltest.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AssignmentRequestRepository assignmentRequestRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OperationRecordCreated'"
    )
    public void wheneverOperationRecordCreated_AssignmentRequestCreationPolicy(
        @Payload OperationRecordCreated operationRecordCreated
    ) {
        OperationRecordCreated event = operationRecordCreated;
        System.out.println(
            "\n\n##### listener AssignmentRequestCreationPolicy : " +
            operationRecordCreated +
            "\n\n"
        );
        // Comments //
        //운행 실적 생성 시 관련 배차 요청을 자동으로 생성하여 프로세스를 자동화

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
