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
    OperationSummaryRepository operationSummaryRepository;

    @Autowired
    DashboardMetricsRepository dashboardMetricsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OperationRecordCreated'"
    )
    public void wheneverOperationRecordCreated_OperationSummaryUpdatePolicy(
        @Payload OperationRecordCreated operationRecordCreated
    ) {
        OperationRecordCreated event = operationRecordCreated;
        System.out.println(
            "\n\n##### listener OperationSummaryUpdatePolicy : " +
            operationRecordCreated +
            "\n\n"
        );
        // Comments //
        //운행 실적 생성 후 운영 요약 데이터가 최신 상태로 유지되도록 보장

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
