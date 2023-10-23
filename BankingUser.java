
/**
 * 
 */
package javaProject;

import java.util.concurrent.ThreadLocalRandom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 * @author Dhairya Shah
 *
 */
public class User {

	/**
	 * @param args
	 */
	//variable declarations
	//fname = store first name of user
	//lname = store last name of user
	//address = store address of user
	//dob = store date of birth of user
	//email = store email of user
	//user_id = store user_id of user
	//saving_account = store saving account no of user
	//current_account = store current account of user
	//saving_account_balance = store saving account balance of user
	//current_account_balance = store current_account_balance of user
	//contact_no = store contact no of user
	//sin_no = store sin no of user
	
	private String Fname,Lname,Address,DOB,Email,User_id;
	private int Savings_Account, Current_Account,Saving_Account_Balance,Current_Account_Balance;;
	//private double 
	private long SIN_no,Contact_no;
	
	public User() 
	{
		/**
		 * User constructor without arguments
		 */
		this.Fname="";
		this.Lname="";
		this.Address="";
		this.DOB="";
		this.Email="";
		this.User_id="";
		this.SIN_no=0;
		this.Contact_no=0;
		this.Savings_Account=0;
		this.Current_Account=0;
		this.Saving_Account_Balance=0;
		this.Current_Account_Balance=0;
	}
	
	public User(String Fname,String Lname,String Address, String DOB, String Email,long Contact_no, String acctype_choice,  long SIN_no) 
	{
		/**
		 * User constructor with arguments
		 */
		this.Fname=Fname;
		this.Lname=Lname;
		this.Address=Address;
		this.DOB=DOB;
		this.Email=Email;
		this.User_id= Fname.toLowerCase() + Lname.toLowerCase() + String.valueOf(ThreadLocalRandom.current().nextInt(100,1000));
		this.SIN_no=SIN_no;
		this.Contact_no=Contact_no;
		if(Integer.parseInt(acctype_choice) == 1)
		{
			this.Savings_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
			this.Current_Account = 0;
		}
		else if(Integer.parseInt(acctype_choice) == 2)
		{
			this.Savings_Account = 0;
			this.Current_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
		}
		else if(Integer.parseInt(acctype_choice) == 3)
		{
			this.Savings_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
			this.Current_Account = ThreadLocalRandom.current().nextInt(1000000,10000000);
		}
		this.Saving_Account_Balance=0;
		this.Current_Account_Balance=0;
		//this.Saving_Account_Balance=0;
	}
