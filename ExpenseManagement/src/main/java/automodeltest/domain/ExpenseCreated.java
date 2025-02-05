package automodeltest.domain;

import automodeltest.domain.*;
import automodeltest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ExpenseCreated extends AbstractEvent {

    private VehicleId vehicleId;
    private ExpenseType expenseType;
    private Money amount;
    private Date date;
    private String description;

    public ExpenseCreated(Expense aggregate) {
        super(aggregate);
    }

    public ExpenseCreated() {
        super();
    }
}
//>>> DDD / Domain Event
