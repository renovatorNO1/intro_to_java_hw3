package hw3;
/**
 * This class is to validate whether a credit card number is 
 * legitimate or not.
 * @author Yuxuan
 *
 */
public class CreditCard {
	final int LENGTH = 12;//predefine the length of an array
	int[] numbers = new int[LENGTH];// set up array numbers 
	
	public int errorCode=0;//initialize public variable errorCode  
	public boolean Valid = true;//initialize public variable Valid
	/**
	 * isValid will return the value of Valid
	 * @return
	 */
	public boolean isValid(){
		return this.Valid;
	}
	/**
	 * get the errorCode for the card
	 * @return
	 */
	public int getErrorCode() {
		return this.errorCode;
	}
	/**
	 * initialize class instance;
	 * store the cardNumber into numbers as an array 
	 * @param cardNumber
	 */
	public CreditCard(String cardNumber){
		for (int i=0;i<=11;i++) {
			this.numbers[i] = Integer.parseInt(cardNumber.substring(i,i+1));
		}
	}
	/**
	 * First check whether the first digit is 4
	 * @return
	 */
	private boolean check1(){
		int digit_1 = this.numbers[0];
		if (digit_1 != 4) {
			this.Valid = false;
		}
		return this.Valid;		
	}
	/**
	 * Second check whether the difference between 
	 * the fourth and fifth digits is 1
	 * @return
	 */
	private boolean check2(){
		int difference = this.numbers[3]-this.numbers[4];
		if (difference != 1 ) {
			this.Valid = false;
		}
		return this.Valid;	
	}
	/**
	 * Check if the product of the 1st, 5th, 9th digit is 24
	 * @return
	 */
	private boolean check3(){
		int product = this.numbers[0]*this.numbers[4]*this.numbers[8];
		if (product != 24) {
			this.Valid = false;
		}
		return this.Valid;
	}
	/**
	 * Check if the sum of all the digits is divisible by 4
	 * @return
	 */
	private boolean check4() {
		int sum=0;
		for (int i: this.numbers) {
			sum += i;
		}
		if (sum % 4 != 0) {
			this.Valid = false;
		}
		return this.Valid;		
	}
	/**
	 * Check if the sum of the first 4 digits is one less than
	 * the sum of the last 4 digits
	 * @return
	 */
	private boolean check5() {
		int head_sum=0;
		for (int counter1=0;counter1<=3;counter1++) {
			head_sum += this.numbers[counter1];
		}
		int tail_sum=0;
		for (int counter2=8;counter2<=11;counter2++) {
			tail_sum += this.numbers[counter2];
			
		}
		if (head_sum - tail_sum != -1) {
			this.Valid = false;
		} 
		return this.Valid;
	}
	/**
	 * Check if the doubled digit number made of the first 2 digits
	 * plus the the doubled digit number made of the 5th and 6th digit
	 *  is equal to 100
	 * @return
	 */
	private boolean check6() {
		int sumOfTwoDigitsNum;
		sumOfTwoDigitsNum = 10*this.numbers[0]+this.numbers[1]
							+10*this.numbers[6]+this.numbers[7];
		if (sumOfTwoDigitsNum != 100) {
			this.Valid = false;
		}
		return this.Valid;
	}
	/**
	 * Check method group all the individual check methods together,
	 * and assign errorCode by the first failed check.
	 * if the card number passes all the checks, then set errorCode 0.  
	 */
	public void check(){
		if (!check1()) {
			this.errorCode = 1;
		} else if (!check2()) {
			this.errorCode = 2;
		} else if (!check3()) {
			this.errorCode = 3;
		} else if (!check4()) {
			this.errorCode = 4;
		} else if (!check5()) {
			this.errorCode = 5;
		} else if (!check6()) {
			this.errorCode = 6;
		} else  {
			this.errorCode = 0;
		}
	}	
}
