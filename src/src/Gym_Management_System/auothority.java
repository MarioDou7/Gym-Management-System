package src.Gym_Management_System;

import java.util.Scanner;

public abstract class auothority {
    Scanner sc = new Scanner(System.in);
    boolean isFound ;
    static Session []SessionsArray = new Session[10];
    static Member[] MembersArray = new Member[10];
    String []phone = new String[3];
    int    SSN;
    int Salary;
    String Hire_Date;
    String Name;
    String Sex;
    String Address;

    public auothority(String Name, int SSN, String Sex, String Address, String PhoneNumber, int Salary, String Hire_Date){
        this.Name      = Name;
        this.SSN       = SSN;
        this.Sex       = Sex;
        this.Address   = Address;
        for (int i = 0; i < 3; i++)
        {
            if(phone[i] == null)
            {
                phone[i] = PhoneNumber;
            }
        }
        this.Salary    = Salary;
        this.Hire_Date = Hire_Date;
    }

    protected void Members_of_session(String date){
        
        isFound = false;
        for (Session Session : auothority.SessionsArray) 
        {
            if(Session == null)
                continue;
            if(Session.date.equals(date))
            {   isFound = true;
                Session.display_membersInSession();
                break;
            }
        }
        if(isFound == false)
            System.out.println("No Sessions in that date");
    }

    protected void Members_of_membership(String type)
    {
        
        isFound = false;
        for (Member member : MembersArray) 
        {
            if(member == null)
                continue;
            if(member.MemberShip.equals(type)){
                isFound = true;
                System.out.println(member);
            }
        }
        if(isFound == false)
            System.out.println("No Members with this Membership");
    }

    protected void ViewMembers_info(Member[] members){
         isFound = false;
        for (Member member : members) {
            if(member == null)
                continue;
            if (member != null) {
                isFound = true ;
                System.out.println(member);
            }
        }
        if(isFound == false)
            System.out.println("No Members Found");
    }
    protected void appendValue(Object[] Objects,Object Object){
        for (int i = 0 ; i<10; i++) {
            if(Objects[i] == null){
                Objects[i] = Object;
                break;
            }
        }

    }
    protected void removeValue(Object[] Objects,Object Object){
        for (int i = 0 ; i<10; i++) 
        {    
            if(Objects[i] == Object){
                Objects[i] = null;
                break;
            }
        }

    }

}
