import java.io.*;
import java.util.*;


interface Bank {

	public void CreateAccount();
	public void Deposit(double amount);
	public void Withdraw(double amount) throws InsufficientBalance;
	public double GetBalance();
	public float GetAnnualInterest();
	
}

// Exception class
class InsufficientBalance extends Exception{
	String message;
    
    public InsufficientBalance(String message) {
        super(message);
        this.message = message;
        
    }
    
    public String getMessage() {
        return message;
    }
}


class SBI implements Bank{
	static float interest_rate=3.0f;
	long Bankid = 294564146;
	String  Branch, Location; 
	double Balance;
	
	void SetInterestRate(float interest){
		interest_rate=interest;
		System.out.println("Interest rate has been set to "+interest_rate);
	}
	public void CreateAccount(){
	
		Branch="SBI20201231";
		Location="Kormangala, Bangalore";
		Balance=0;
	}
	public void Deposit(double amount){
		this.Balance+=amount;
	}
	public void Withdraw(double amount) throws InsufficientBalance{
        if (amount > Balance) {
            throw new InsufficientBalance("Insufficient Balance!!");
        } 
		else {
            this.Balance -= amount;
        }
    } 
	public double GetBalance(){
		return this.Balance;
	}
	public float GetAnnualInterest(){
		return interest_rate;
	}
	
}


class HDFC implements Bank{
	static float interest_rate=3.0f;
	long Bankid = 294564146;
	String  Branch, Location; 
	double Balance;
	
	void SetInterestRate(float interest){
		interest_rate=interest;
		System.out.println("Interest rate has been set to "+interest_rate);
	}
	public void CreateAccount(){
	
		Branch="HDFC20201231";
		Location="Kormangala, Bangalore";
		Balance=0;
	}
	public void Deposit(double amount){
		this.Balance+=amount;
	}
	public void Withdraw(double amount) throws InsufficientBalance{
        if (amount > Balance) {
            throw new InsufficientBalance("Insufficient Balance!!");
        } 
		else {
            this.Balance -= amount;
        }
    } 
	public double GetBalance(){
		return this.Balance;
	}
	public float GetAnnualInterest(){
		return interest_rate;
	}
	
}

class ICICI implements Bank{
	static float interest_rate=3.0f;
	long Bankid = 294564146;
	String  Branch, Location; 
	double Balance;
	
	void SetInterestRate(float interest){
		interest_rate=interest;
		System.out.println("Interest rate has been set to "+interest_rate);
	}
	public void CreateAccount(){
	
		Branch="ICICI20201231";
		Location="Kormangala, Bangalore";
		Balance=0;
	}
	public void Deposit(double amount){
		this.Balance+=amount;
	}
	public void Withdraw(double amount) throws InsufficientBalance{
        if (amount > Balance) {
            throw new InsufficientBalance("Insufficient Balance!!");
        } 
		else {
            this.Balance -= amount;
        }
    } 
	public double GetBalance(){
		return this.Balance;
	}
	public float GetAnnualInterest(){
		return interest_rate;
	}
	
}


class Person extends SBI{
	int PersonId;
	String Name, AccountType, Email;
	static String  BankName="SBI";
	long AccountNumber;
	double Balance;
	
	void AccountDetails() {
		System.out.println("Person ID : "+this.PersonId);
		System.out.println("Name : "+this.Name);
		System.out.println("Bank ID : "+this.Bankid);
		System.out.println("Bank Name : "+BankName);
		System.out.println("Account Type : "+this.AccountType);
		System.out.println("Balance : "+this.Balance);
		System.out.println("Interest Rate : "+this.interest_rate);
	}
	
	//Max balance of a person
	public static void MaxBalancePerson(Person[] person, int nopeople){
		double max=person[0].Balance;
		int index=0;
		for(int i=0;i<nopeople;i++){
			if(person[i].Balance>max){
				index=i;
			}
		}
		System.out.println("Person with maximum balance is "+person[index].Name);
	}
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		String choice="";
		int nopeople;
		
		System.out.println("Enter the number of people ");	
		nopeople=Integer.parseInt(in.nextLine());
		Person[] p=new Person[nopeople];
				
		for(int i=0;i<nopeople;i++){
			choice="";
			p[i]=new Person();
			p[i].PersonId = i;
			System.out.println("\nEnter the details for person "+(i+1));
			System.out.println("Enter Name : ");
			String nme = in.nextLine();
			p[i].Name = nme.substring(0, 1).toUpperCase() + nme.substring(1);
			System.out.println("Enter Email : ");
			p[i].Email = in.nextLine();
			System.out.println("Enter Account Number: ");	//pending : use math class
			p[i].AccountNumber = Long.parseLong(in.nextLine());
			System.out.println("Type of Account ");
			while(true){
				System.out.println("For current account press C\nFor savings account press S");
				String taccounttype=in.nextLine();
				if (taccounttype.toUpperCase().equals("C")){
					p[i].AccountType = "Current";
					break;
				}
				else if(taccounttype.toUpperCase().equals("S")){
					p[i].AccountType = "Savings";
					break;
				}
				else
					System.out.println("Given input is not valid. Please try again.");
			}
			
			System.out.println("Do you want to deposit money? Y/N ");
			choice=in.nextLine();
			double amt;
			if(choice.toUpperCase().equals("Y")){
				System.out.println("Enter the amount to be deposited ");
				amt=Double.parseDouble(in.nextLine());
				p[i].Deposit(amt);
				p[i].Balance=p[i].GetBalance();
			}
			p[i].AccountDetails();
			
		}
		
		System.out.println("\nTo make any transaction in account enter Y");
		choice=in.nextLine();
		if(choice.toUpperCase().equals("Y")){
			while(true){
				double amt=0;
				System.out.println("\nEnter the person id to whose account you want to make transaction ");
				int id=Integer.parseInt(in.nextLine());
				if(!(id>0&&id<nopeople)){
					System.out.println("Given id is incorrect!!");	
					break;
				}
				System.out.println("For deposit enter D\nFor withdrawal enter W");
				choice=in.nextLine();
				choice=choice.toUpperCase();
				switch(choice){
				case "D":
						System.out.println("Enter the amount to be deposited ");
						amt=Double.parseDouble(in.nextLine());
						p[id].Deposit(amt);
						p[id].Balance=p[id].GetBalance();
						break;
				
				case "W":
						System.out.println("Enter the amount to be withdrawn ");
						amt=Double.parseDouble(in.nextLine());
						try{
							p[id].Withdraw(amt);			
							p[id].Balance=p[id].GetBalance();
						}
						catch(InsufficientBalance e){
							System.out.println(e.getMessage());
						}
						break;
				default:
						System.out.println("Invalid input!!");
				
				}
				System.out.println("Do you want to make another transaction Y/N");
				choice=in.nextLine();
				if(!(choice.toUpperCase().equals("Y")))
					break;
			
			}
		}
		
		
		MaxBalancePerson(p,nopeople);
	}
}