package automodeltest.domain;

import automodeltest.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "expenses", path = "expenses")
public interface ExpenseRepository
    extends PagingAndSortingRepository<Expense, Long> {
    @Query(
        value = "select expense " +
        "from Expense expense " +
        "where(:vehicleId is null or expense.vehicleId = :vehicleId) and (:expenseType is null or expense.expenseType = :expenseType) and (:amount is null or expense.amount = :amount) and (:date is null or expense.date = :date) and (:description is null or expense.description like %:description%)"
    )
    List<Expense> expenseSummary(
        VehicleId vehicleId,
        ExpenseType expenseType,
        Money amount,
        Date date,
        String description,
        Pageable pageable
    );

    @Query(
        value = "select expense " +
        "from Expense expense " +
        "where(:vehicleId is null or expense.vehicleId = :vehicleId) and (:expenseType is null or expense.expenseType = :expenseType) and (:amount is null or expense.amount = :amount) and (:date is null or expense.date = :date) and (:description is null or expense.description like %:description%)"
    )
    Expense expenseDetails(
        VehicleId vehicleId,
        ExpenseType expenseType,
        Money amount,
        Date date,
        String description
    );
}
