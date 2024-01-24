package com.example;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {
    @Mock
    private EmployeeRepository repository;

    @Mock
    private BankService service;

    @InjectMocks
    private Employees employees;

    private List<Employee> employeeList;

    @BeforeEach
    void init() {
        employeeList = List.of(new Employee("1", 123), new Employee("2", 321));
    }


    @Test
    @DisplayName("Each employee got payment")
    void eachEmployeeGotPayment() {
        when(repository.findAll()).thenReturn(employeeList);

        int payments = employees.payEmployees();

        assertThat(employeeList).allSatisfy(employee -> assertThat(employee.isPaid()).as("all employees are paid").isTrue());
        assertThat(employeeList.size()).as("all payments where successful").isEqualTo(payments);

    }


    @Test
    @DisplayName("Employee did not get a payment")
    void employeeDidNotGetAPayment() {
        when(repository.findAll()).thenReturn(employeeList);
        doThrow(RuntimeException.class).when(service).pay("1", 123);

        int payments = employees.payEmployees();

        assertThat(payments).as("Only one payment is successful").isEqualTo(1);

        assertThat(employeeList.get(0).isPaid()).as("First employee").isFalse();
        assertThat(employeeList.get(1).isPaid()).as("Second employee").isTrue();
    }

    @Test
    @DisplayName("Each employee got payment with doubles")
    void eachEmployeeGotPaymentWithDoubles() {
        // Employees called so just for coverage because can't think of better solution where to put them.
        // Also created empty Constructor otherwise it would be wierd  to call set methods on already existing data.
        Employee employee1 = new Employee().setId("1").setSalary(2222);
        Employee employee2 = new Employee().setId("2").setSalary(3333);
        StubRepository stubRepository = new StubRepository();
        StubBankService stubBankService = new StubBankService();
        SoftAssertions soft = new SoftAssertions();
        // use instead of list that in beforeEach because need to justify this two employees
        stubRepository.add(employee1);
        stubRepository.add(employee2);

        Employees dummyEmployees = new Employees(stubRepository, stubBankService);

        int payments = dummyEmployees.payEmployees();

        assertThat(payments).isEqualTo(2);
        assertThat(stubBankService.getCalled()).isEqualTo(2);

        soft.assertThat(stubRepository).satisfies(stubRepository1 -> {
            assertThat(stubRepository1.getCountAddedUsers()).isEqualTo(2);
            assertThat(stubRepository1.getCountFoundAllUsers()).isEqualTo(1);
        });
        soft.assertAll();
    }

    @Test
    @DisplayName("Employee did not get a payment with Doubles")
    void employeeDidNotGetAPaymentWithDoubles() {
        StubRepository stubRepository = new StubRepository();
        StubBankService stubBankService = new StubBankService();

        employeeList.forEach(stubRepository::add);

        Employees dummyEmployees = new Employees(stubRepository, stubBankService);

        stubBankService.setException(true);
        int payments = dummyEmployees.payEmployees();

        assertThat(payments).isEqualTo(1);
    }
}