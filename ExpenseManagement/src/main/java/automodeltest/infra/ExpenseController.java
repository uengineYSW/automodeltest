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
// @RequestMapping(value="/expenses")
@Transactional
public class ExpenseController {

    @Autowired
    ExpenseRepository expenseRepository;

    @RequestMapping(
        value = "/expenses",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Expense createExpense(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateExpenseCommand createExpenseCommand
    ) throws Exception {
        System.out.println("##### /expense/createExpense  called #####");
        Expense expense = new Expense();
        expense.createExpense(createExpenseCommand);
        expenseRepository.save(expense);
        return expense;
    }
}
//>>> Clean Arch / Inbound Adaptor
