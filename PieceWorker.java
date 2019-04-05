public class PieceWorker extends Employee {
	
	private double wage;
	private int pieces;
	
	//Constructor
	//Checks that variables are set to values greater than 0
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		if(wage <= 0) {
			throw new IllegalArgumentException("Wage must be >0");
		}
		if(pieces <= 0) {
			throw new IllegalArgumentException("Pieces must be >0");
		}
		this.wage = wage;
		this.pieces = pieces;
	}
	
	//Getters and setters
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	
	@Override public double earnings() {
		return wage * pieces;
	}
	
	@Override public String toString() {
		return String.format("piece worker: %s%n%s: $%,.2f; %s: %d", super.toString(),"wage per piece",
				getWage(), "pieces made", getPieces());
	}
}