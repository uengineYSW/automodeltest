package automodeltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateExpenseCommand {

    private VehicleId vehicleId;
    private ExpenseType expenseType;
    private Money amount;
    private Date date;
    private String description;
}
