public class PayrollSystemTest{
	
	/*
	 * I did my best to blend together all four of the problems that were assigned.
	 * 
	 * 10.12: I added the Date class with getters and setters and made a few related modifications to the Employee
	 * Constructor and toString method, as well as adding birthDate related methods and getBirthMonth method.
	 * During the PayrollSystem iteration through the array, if the payable object is an Employee, the birth month
	 * is checked against the month of the now Date object, and if equal 100 is added to their payment due.
	 * 
	 * 10.14: I added the PieceWorker class with Constructor, getter, setter, earnings, and toString methods, and
	 * instantiated a PieceWorker object in the main method below.
	 * 
	 * 10.15: Added the Payable interface and implemented it in the Employee class, 10% raise to base salary is given
	 * to BasePlusCommissionEmployee as PayrollSystem iterates through the array of Payable Objects.
	 */
	
	public static void main(String[] args) {
				
		//Date object for payroll system
		Date now = new Date(4,4,2019);
		
		//create four-element Employee array
		Payable[] payables = new Payable[7];
		
		//initialize array with Employees
		payables[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800);
		payables[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		payables[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		payables[3] = new BasePlusCommissionEmployee("Bob","Lewis","444-44-4444", 5000, .04, 300);
		payables[4] = new PieceWorker("Tom", "Turner", "555-55-5555", 4.85, 135);
		payables[5] = new Invoice("01234", "seat", 2, 375.00);
		payables[6] = new Invoice("56789", "tire", 4, 79.95);
		
		//setting the birthDates for the employee objects created above
		((Employee) payables[0]).setBirthDate(5, 12, 1978);
		((Employee) payables[1]).setBirthDate(4, 22, 1985);
		((Employee) payables[2]).setBirthDate(9, 3, 1993);
		((Employee) payables[3]).setBirthDate(12, 23, 1967);
		((Employee) payables[4]).setBirthDate(1, 23, 2000);
		
		//Iterate through all objects in the payables array
		for (Payable currentPayable : payables) {
			//Call the toString() of the payable
			System.out.println(currentPayable);
			if (currentPayable instanceof Employee) { //check if payable is an Employee
				Employee currentEmployee = (Employee) currentPayable; //Downcast to Employee
				if (currentEmployee instanceof BasePlusCommissionEmployee) {
					//check if Employee is a BasePlusComEmployee
					BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;//downcast
					employee.setBaseSalary(1.10 * employee.getBaseSalary());//raise base salary
					System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
				}
				if (currentEmployee.getBirthMonth() == now.getMonth()) {
					//check Employee birth month
					System.out.println("Happy Birthday, enjoy the $100 bonus!");
					System.out.printf("payment due $%,.2f%n%n", (currentEmployee.getPaymentAmount() + 100));
				}
				else {
					System.out.printf("payment due $%,.2f%n%n", currentEmployee.getPaymentAmount());
				}
			}
			else {
				System.out.printf("payment due $%,.2f%n%n", currentPayable.getPaymentAmount());
			}
		}
	}
}