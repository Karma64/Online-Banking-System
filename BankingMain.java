package javaProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

/**
 * 
 *
 */
public class JavaProject extends User{

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	//TransferAmount =  is for amount to be transferred to other bank account
	//flag = to check the beneficiary account no (0 = invalid and 1 = valid)
	public static String TransferAmount="";
	static int flag=0;
	public static void main(String[] args) throws IOException {
		/**
		 * options = will fetch the input from user.
		 * uid = to store user unique id.
		 * choice = will fetch the input from existing user.
		 * fname = store first name
		 * lname = store last name
		 * address = store address
		 * email = store email
		 * contact no = store contact no
		 * dob = store dob
		 * sin = store sin no
		 * acctype = will store the decision of user; whether user want to create savings account or current account or both.
		 */
		int options;
		String uid="";
		do {
			options =Integer.parseInt(JOptionPane.showInputDialog("Enter 1. If you are a existing User.\r\n "
			+ "Enter 2. If you are a new User.\r\n"
			+ "Enter 0. Exit\n"));
			if(options!=0 && options!=2)
				uid = JOptionPane.showInputDialog("Enter your user id");
				uid=uid+".txt";
			File checkUser = new File(uid);
			if(options==1 && checkUser.exists()) 
			{
				int choice=-1;
				while(choice!=0)
				{
					choice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1. 	Display their current balance \r\n"
							+ "Enter 2. Deposit money  \r\n"
							+ "Enter 3. Draw money and (charge a fee : $3 )\r\n"
							+ "Enter 4. Transfer money to other accounts within the bank \r\n"
							+ "Enter 5. Pay utility bills  \r\n"
							+ "Enter 6. To create new account type\r\n"
							+ "Enter 7. To view your bank details \r\n"
							+ "Enter 8. To edit your bank details\r\n"
							+ "Enter 9. To Delete Account\r\n"
							+ "Enter 0. To go back\n"));
					if(choice==1)
					{
						checkBalance(uid);
					
					}
					else if(choice==2) 
					{
						depositMoney(uid);
					}
					else if(choice==3)
					{
						drawMoney(uid);
					}
					else if(choice==4)
					{
						moneyTransfer(uid);
					}
					else if(choice==5)
					{
						payUtilityBills(uid);
					}
					else if(choice==6)
					{
						checkAccount(uid);
					}	
					else if(choice==7)
					{
						viewDetails(uid);
					}
					else if(choice==8)
					{
						editDetails(uid);
					}
					else if(choice==9)
					{
						deleteAccount(uid);
					}
				}
			}
			else if(options==2) 
			{
				//User account will be created here. and object.save function will generate a file for that user
				User u;
				String fname,lname,DOB,address,Email;
				long contact_no,sin_no;
				String acctype_choice;
				ArrayList<String> UserList = new ArrayList<String>();
				
				fname = JOptionPane.showInputDialog("Enter your First Name ");
				lname = JOptionPane.showInputDialog("Enter your Last Name ");
				address = JOptionPane.showInputDialog("Enter your address ");
				DOB  = JOptionPane.showInputDialog("Enter your Date of Birth ");
				Email  = JOptionPane.showInputDialog("Enter your Email ");
				contact_no = Long.parseLong(JOptionPane.showInputDialog("Enter your contact no "));
				sin_no = Long.parseLong(JOptionPane.showInputDialog("Enter your SIN no "));
				acctype_choice = JOptionPane.showInputDialog("Enter 1. To create a saving account \n"
						+ "Enter 2. To create a current account \n"
						+ "Enter 3. To create both ");
				u=new User(fname,lname,address,DOB,Email,contact_no,acctype_choice,sin_no);
				u.save();
				
				UserList.add("User name : "+(fname+" "+lname)+" User_ID : "+u.getUser_id());
				System.out.println(UserList);
				
				File file =  new File("UserData.txt");
				FileWriter fw = new FileWriter(file,true);
				
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("\n"+UserList.get(0));
				//fw.append(UserList.get(0));
				bw.close();
				fw.close();
				
				JOptionPane.showMessageDialog(null, "Your User id : "+u.getUser_id());
			}
			else if(options==0 || options==2)
			{
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null,"INVALID USER ID");
			}
		}while(options!=0);
	}

