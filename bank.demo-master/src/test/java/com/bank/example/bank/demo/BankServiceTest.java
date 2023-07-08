package com.bank.example.bank.demo;

import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.model.employee.EmployeeFunction;
import com.bank.example.bank.demo.model.employee.Employees;
import com.bank.example.bank.demo.model.currency.ExchangeCurrency;
import com.bank.example.bank.demo.service.clientService.ClientService;
import com.bank.example.bank.demo.service.employeesService.EmployeesService;
import com.bank.example.bank.demo.service.exchangeCurrency.ExchangeCurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class BankServiceTest {

	@Autowired
	private ClientService clientService;

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private ExchangeCurrencyService exchangeCurrencyService;

	@BeforeEach
	public void setup() {
		// Inițializați alte dependențe necesare pentru test, dacă este cazul
	}

	@Test
	public void testAddClient() {
		Client client = new Client();
		client.setFirstName("Tatiana");
		client.setLastName("Borta");
		client.setPhoneNumber("077564456");
		client.setIdnp("2000234567845");

		clientService.addClient(client);

		List<Client> clients = clientService.loadAllClient();
		Assertions.assertEquals(1, clients.size());
		Assertions.assertEquals(client, clients.get(0));
	}

	@Test
	public void testAddEmployees() {
		Employees employees = new Employees();
		employees.setFirstName("Artiom");
		employees.setLastName("Stratulat");
		employees.setFunction(EmployeeFunction.MANAGER);
		employees.setMobileNumber("+445678695932");

		Employees employees1 = new Employees();
		employees1.setFirstName("Dumitru");
		employees1.setLastName("Vivat");
		employees1.setFunction(EmployeeFunction.DIRECTOR);
		employees1.setMobileNumber("+373797965043");

		Employees employees2 = new Employees();
		employees2.setFirstName("Grigore");
		employees2.setLastName("Borta");
		employees2.setFunction(EmployeeFunction.CASIER);
		employees2.setMobileNumber("+3736879045634");

		employeesService.addEmployees(employees);
		employeesService.addEmployees(employees1);
		employeesService.addEmployees(employees2);

		List<Employees> employeesList = employeesService.loadAllEmployees();
		Assertions.assertEquals(3, employeesList.size());
		Assertions.assertEquals(employees, employeesList.get(0));
		Assertions.assertEquals(employees1, employeesList.get(1));
		Assertions.assertEquals(employees2, employeesList.get(2));
	}

	@Test
	public void testAddExchangeCurrency() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2008, 2, 12);
		Date date = calendar.getTime();

		ExchangeCurrency exchangeCurrency = new ExchangeCurrency();
		exchangeCurrency.setDate(date);
		exchangeCurrency.setBuyUSD((long) 17.80);
		exchangeCurrency.setSellEUR((long) 19.84);

		exchangeCurrencyService.addExchangeCurrency(exchangeCurrency);
		Calendar calendar1 = Calendar.getInstance();
		calendar.set(2008, 2, 13);
		Date date1 = calendar.getTime();

		ExchangeCurrency exchangeCurrency1 = new ExchangeCurrency();
		exchangeCurrency.setDate(date);
		exchangeCurrency.setBuyUSD((long) 17.50);
		exchangeCurrency.setSellEUR((long) 19.54);

		exchangeCurrencyService.addExchangeCurrency(exchangeCurrency);

		ExchangeCurrency foundExchangeCurrency = exchangeCurrencyService.findExchangeCurrencyByDate(date);
		Assertions.assertEquals(exchangeCurrency, foundExchangeCurrency);
	}

	@Test
	public void testFindClientByIdnp() {
		String idnp = "2000234567845";

		Client client = new Client();
		client.setIdnp(idnp);
		clientService.addClient(client);

		Client foundClient = clientService.findClientByIdnp(idnp);
		Assertions.assertEquals(client, foundClient);
	}

	@Test
	public void testFindEmployeesByID() {
		long id = 1L;

		Employees employees = new Employees();
		employees.setId(id);
		employeesService.addEmployees(employees);

		Employees foundEmployees = employeesService.findEmployeesByID(id);
		Assertions.assertEquals(employees, foundEmployees);
	}
}
