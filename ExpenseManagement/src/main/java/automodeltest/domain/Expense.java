package automodeltest.domain;

import automodeltest.ExpenseManagementApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Expense_table")
@Data
//<<< DDD / Aggregate Root
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expenseId;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @Embedded
    private Money amount;

    private Date date;

    private String description;

    @Embedded
    private VehicleId vehicleId;

    public static ExpenseRepository repository() {
        ExpenseRepository expenseRepository = ExpenseManagementApplication.applicationContext.getBean(
            ExpenseRepository.class
        );
        return expenseRepository;
    }

    //<<< Clean Arch / Port Method
    public void createExpense(CreateExpenseCommand createExpenseCommand) {
        //implement business logic here:

        ExpenseCreated expenseCreated = new ExpenseCreated(this);
        expenseCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
