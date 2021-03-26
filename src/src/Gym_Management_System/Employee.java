package src.Gym_Management_System;

import java.util.Scanner;

public class Employee extends auothority{
    boolean isFound;
    Scanner scan = new Scanner(System.in);
    
    public Employee(String Name, int Salary, int SSN, String Sex, String Address, String PhoneNumber, String Hire_Date){
        super(Name, SSN, Sex, Address, PhoneNumber, Salary, Hire_Date);
    }

    public void AddMember_System(){
        String Name;
        String Sex;
        String Address;
        String phoneNumber;
        String MemberShip;
        Double weight;
        Member member;

        System.out.printf("Please Enter The Member Name: ");
        Name = scan.next();
        System.out.printf("Male or Female: ");
        Sex = scan.next();
        System.out.printf("Address: ");
        Address = scan.next();
        System.out.printf("PhoneNumber: ");
        phoneNumber = scan.next();
        System.out.printf("MemberShip: ");
        MemberShip = scan.next();
        System.out.printf("Weight: ");
        weight = scan.nextDouble();

        member = new Member(Name, Sex, Address, phoneNumber, MemberShip, weight,MembersArray);
        appendValue(MembersArray, member);
        System.out.println("---------------------------------");
        System.out.println(member);
        System.out.println("---------------------------------");
        System.out.println("Member added successfully");
        System.out.println("---------------------------------");

    }
    public void EditMember_System(int MemberID){
        int choice;
        String Name;
        String Sex;
        String Address;
        String phoneNumber;
        String MemberShip;
        Double weight;
        boolean Done = false;
        isFound = false;
        for (Member member : MembersArray) {
            if(member == null)
                continue;
            if(member.SSN == MemberID){
                isFound = true;
                System.out.println("-------------------");
                System.out.println(member);
                System.out.println("-------------------");
                System.out.println("Choose which element would you like to edit:");
                System.out.println("Enter 0 when you are Done");
                System.out.println("1: Name");
                System.out.println("2: Sex");
                System.out.println("3: Address");
                System.out.println("4: PhoneNumber");
                System.out.println("5: MemberShip");
                System.out.println("6: Weight");
                while (Done != true){
                    
                    System.out.printf("Your choice: ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 0:
                            Done = true;
                            System.out.println("Saved.");
                            break;
                        case 1:
                            System.out.printf("Enter the new Name: ");
                            Name = scan.next();
                            member.Name = Name;
                            break;
                        case 2:
                            System.out.printf("Enter the new Sex: ");
                            Sex = scan.next();
                            member.Sex = Sex;
                            break;
                        case 3:
                            System.out.printf("Enter the new Address: ");
                            Address = scan.next();
                            member.Address = Address;
                            break;
                        case 4:
                            System.out.printf("Enter the new PhoneNumber: ");
                            phoneNumber = scan.next();
                            System.out.printf("Enter the index of the phoneNumber(1/2/3): ");
                            int index = scan.nextInt();
                            member.phone[index] = phoneNumber;
                            break;                        
                        case 5:
                            System.out.printf("Enter the new MemberShip: ");
                            MemberShip = scan.next();
                            member.MemberShip = MemberShip;
                            break;           
                        case 6:
                            System.out.printf("Enter the new Weight: ");
                            weight = scan.nextDouble();
                            member.weight = weight;
                            break; 
                        default:
                            System.out.println("Enter Number form range (0-5)");
                            break;
                    }
                    System.out.println("edit is saved");
                    System.out.println("---------------------------------");

                }
            }
        }
        if(isFound == false)
            System.out.println("There is no Member with this ID in  the System");
    }
    public void RemoveMember_System(int MemberID){
        isFound = false;
        for (Member member : MembersArray) 
        {   if(member == null)
              continue;
            if(member.SSN == MemberID){
                
                isFound = true;
                removeValue(MembersArray, member);
                System.out.println("The Member is removed successfully");
            }
            
        }
        if(isFound == false )
             System.out.println("I couldn't find this Member in our System");
    }
    public void AddMember_Session(String date,Member member){
        isFound = false;
        for (Session session : SessionsArray) 
        {   if(session == null)
              continue;
            if(session.date.equals(date))
            {   
                isFound = true;
                appendValue(session.members_in_Session, member);
                System.out.println("Member is Added to the Session");
            }
        }
        if(isFound == false)
            System.out.println("No Session in this date recorded");
    }
    public void RemoveMember_Session(String date,Member member){
        isFound = false;
        for (Session session : SessionsArray) {
            if(session == null)
                continue;
            if(session.date.equals(date)){
                isFound = true;
                removeValue(session.members_in_Session, member);
                System.out.println("Member is Removed from Session");
            }
        }
        if(isFound == false)
           System.out.println("No Session in this date recorded");
    }
}