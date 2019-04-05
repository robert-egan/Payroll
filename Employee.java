//Employee abstract superclass
public abstract class Employee implements Payable{
	
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	//Added the private instance variable birthDate
	private Date birthDate;
	
	// constructor
	//instantiates the birthDate date object with a default 1,1,1 so it can be set later
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.socialSecurityNumber=socialSecurityNumber;
		this.birthDate = new Date(1,1,1);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public int getBirthMonth() {
		return birthDate.getMonth();
	}
	/*
	 * Rather than set birthDate in the employee Constructor I wrote a setter method for birthDate which 
	 * calls the setters from the Date class.
	 */
	public void setBirthDate(int month, int day, int year) {
		birthDate.setMonth(month);
		birthDate.setDay(day);
		birthDate.setYear(year);
	}
	//Added Date of Birth (DOB) to the toString method
	@Override public String toString() {
		return String.format("%s %s%nsocial security number: %s%nDOB: %s", getFirstName(),
				getLastName(),getSocialSecurityNumber(),getBirthDate());
	}
	public abstract double earnings();
	
	@Override public double getPaymentAmount() {
		return earnings();
	}
}