package automodeltest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricsDetails {

    private Integer totalOperations;

    private Double totalDistance;

    private Double averageDistance;

    @Embedded
    private Money money;
}
//>>> DDD / Value Object
