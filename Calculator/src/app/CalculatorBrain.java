/**
 * Author: Julio Rosario
 * last Update: 12.22.2017
 * Purpose: The CalculatorBrain class is the brain/algorithm of the
 * calculator, where all the calculations and decisions are made.
 */

package app;


public class CalculatorBrain {
	
	private double accumulator;
	private String mathSymbol;
	private boolean flag;
	
	
	/**
	 * no-args Constructor
	 */
	CalculatorBrain(){
		accumulator = 0;
		mathSymbol = "";
		flag = false;
	}
	
	/**
	 * The setOperand method set the accumulator
	 * equal to the operand
	 * @param number an operand enter by the user
	 */
	public void setOperand(double number) {
		accumulator = number;
		flag = true;
	}
	
	/**
	 * The setOperator method set the 
	 * field mathSymbol equal to symbol
	 * @param symbol a math symbol for 
	 * arithmetic operation
	 */
	public void setOperator(String symbol) {
		mathSymbol = symbol;
	}
	
	/**
	 * The performUnaryOperation method 
	 * perform a unary operation of the 
	 * accumulator if there is one
	 */
	public void performUnaryOperation() {
		if(set()) {
			if(mathSymbol.equals("cos")) 
	            accumulator = Math.cos(accumulator);
			else if(mathSymbol.equals("sin"))
				accumulator = Math.sin(accumulator);
			else if(mathSymbol.equals("tan"))
				accumulator = Math.tan(accumulator);
			else if(mathSymbol.equals("(-)"))
				   accumulator *=-1;
			else if(mathSymbol.equals("PI"))
				   accumulator = Math.PI;
			else if(mathSymbol.equals("log"))
				accumulator = Math.log(accumulator);
			else if(mathSymbol.equals("ln")) 
				accumulator = Math.log1p(accumulator-1);
			else if(mathSymbol.equals("sqrt")) {
				if(accumulator >=0)
					accumulator = Math.sqrt(accumulator);
			}else if(mathSymbol.equals("clear"))
				clear();	
	  }
	}
	
	/**
	 * The performBinaryOperation method perform 
	 * a binary operation between two operand 
	 * where accumulator is operand 1 and 
	 * @param number is operand 2 of the binary operation
	 */
	public void performBinaryOperation(double number) {
		
		if(set()) {
			if(mathSymbol.equals("/"))
				divide(number);
			else if(mathSymbol.equals("x"))
				multiply(number);
			else if(mathSymbol.equals("+"))
				add(number);
			else if(mathSymbol.equals("-"))
				subtract(number);
		}
	}
	
	/**
	 * The add method receives a 
	 * @param number an operand and add it to
	 * the field accumulator
	 */
	public void add(double number) {
		accumulator += number;
	}
	
	/**
	 * The subtract method receives a 
	 * @param number an operand and subtract it
	 * from the accumulator
	 */
	public void subtract(double number) {
		accumulator -= number;
	}
	
	/**
	 * The multiply method receives a 
	 * @param number an operand and multiply it
	 * by the field accumulator and store it in it.
	 */
	public void multiply(double number) {
		accumulator*=number;
	}
	
	/**
	 * The divide method receives a 
	 * @param number an operand that is 
	 * divide it by the field accumulator
	 */
	public void divide(double number) {
		if(number!= 0)
			accumulator/=number;
	}	
	
	/**
	 * The getResult method 
	 * @return the accumulator of calculations
	 */
	public String  getResult() {
		String tmp1 = String.valueOf(accumulator);
		String decimals = tmp1.substring(tmp1.indexOf(".")+1);
		
		if(decimals.charAt(0) != '0' || decimals.length()>=2) 
			return tmp1;
		else
			 return tmp1.substring(0, tmp1.indexOf("."));
	}
	
	/**
	 * The set method 
	 * @return whether or not the first operand 
	 * has been set.
	 */
	public boolean set() {
		return flag;
	}
	
	/**
	 * The clear method restore 
	 * all the field of this class
	 * to default values.
	 */
	public void clear() {
		flag = false;
		accumulator = 0;
		mathSymbol = "";
	}
}
