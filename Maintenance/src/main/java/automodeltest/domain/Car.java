package automodeltest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Data
public class Car {

    private String carId;

    private String carModel;

    private String licensePlate;

    private String ownerName;
}
