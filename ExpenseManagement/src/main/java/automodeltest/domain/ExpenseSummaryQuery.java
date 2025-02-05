package automodeltest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ExpenseSummaryQuery {

    private VehicleId vehicleId;
    private ExpenseType expenseType;
    private Money amount;
    private Date date;
    private String description;
}
