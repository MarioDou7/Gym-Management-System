package Project;

import java.util.Scanner;

public abstract class auothority {
    Scanner sc = new Scanner(System.in);
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
            if(phone[i] == 0)
            {
                phone[i] = PhoneNumber;
            }
        }
        this.Salary    = Salary;
        this.Hire_Date = Hire_Date;
    }

    protected void Members_of_session(String date){
        System.out.println("Enter Session date: ");
        date = sc.next();
        for (Session Session : auothority.SessionsArray) {
            if(Session.date == date){
                Session.display_membersInSession();
                break;
            }
        }
    }

    protected void Members_of_membership(String type){
        System.out.println("Enter the Membership type: ");
        type = sc.next();
        for (Member member : MembersArray) {
            if(member.MemberShip == type){
                System.out.println(member);
            }
        }
    }

    protected void ViewMembers_info(Member[] members){
        for (Member member : members) {
            if (member != null) {
                System.out.println(member);
            }
        }
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
        for (int i = 0 ; i<10; i++) {
            if(Objects[i] == Object){
                Objects[i] = null;
                break;
            }
        }

    }

}
