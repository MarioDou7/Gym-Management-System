package src.src.Gym_Management_System;

import java.util.Scanner;


public class GymManagementSystem {

    
    public static void main(String[] args) {
        Adminstrator A1 = new Adminstrator("Loka", 17000, 2065, "Male", "Nasr City", "1523945", "12-5-2010");
        Employee     E1 = new Employee("Dou7", 14000, 8477, "Male", "El7mamat", "89828978", "27-6-2012");
        Trainer      T1 = new Trainer("Mazen", 3455, "Male", "Shobra", "01121260503", 3000);
        Member       M1 = new Member("Michael", 7939, "Male", "Shobra", "01096888803", "PAYG", 65.5);
        Session      S1 = new Session("High Intensity Session", "Weight Lifting", "30-12-2020");
        Adminstrator.TrainersArray[0] = T1;
        auothority.SessionsArray[0] = S1;
        auothority.MembersArray [0] = M1;
        
        Scanner scan = new Scanner(System.in);
        String SessionDate;
        String username;
        String password;
        String MembershipType;
        int Trainer_Id;
        int Member_Id;
        int choice;
        boolean Done = false;
        boolean isFound ;
        
        while(true){
        System.out.println("-------- Gym ManagmentSystem --------");
        System.out.printf("Username: ");
        username = scan.next();
        System.out.printf("Password: ");
        password = scan.next();
        
        if(username.equals("admin") && password.equals("admin")){
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("-------- Welcome Admin ----------");
            System.out.println("---------------------------------");
            System.out.println("Choose what you want to do:");
            System.out.println("Enter 0 when you are Done");
            System.out.println("1 : Add Trainer");
            System.out.println("2 : Edit Trainer");
            System.out.println("3 : Remove Trainer");
            System.out.println("4 : Add Session");
            System.out.println("5 : Edit Session");
            System.out.println("6 : Delete Session");
            System.out.println("7 : Assign Trainer to a Member");
            System.out.println("8 : View members under a specific type of membership");
            System.out.println("9 : View any member in a specific session");
            System.out.println("10: View all members info");
            
            while (Done != true){
                System.out.println("---------------------------------");
                System.out.printf("Your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 0:
                        Done = true;
                        System.out.println("Saved.");
                        scan.close();
                        break;
                    case 1:
                        A1.addTrainer_System();
                        break;
                    case 2:
                        System.out.println("Enter Trainer ID: ");
                        Trainer_Id = scan.nextInt();
                        A1.editTrainer_System(Trainer_Id);
                        break;
                    case 3:
                        System.out.println("Enter Trainer ID: ");
                        Trainer_Id = scan.nextInt();
                        A1.RemoveTrainer_System(Trainer_Id);
                        break;
                    case 4:
                        A1.AddSession();
                        break;                        
                    case 5:
                        System.out.println("Enter Session Date: ");
                        SessionDate = scan.next();
                        A1.editSession(SessionDate);
                        break;  
                    case 6:
                        System.out.println("Enter Session Date: ");
                        SessionDate = scan.next();
                        A1.RemoveSession( SessionDate);
                        break;
                    case 7:
                        A1.AssginTrainer_Member();
                        break; 
                    case 8:
                        System.out.println("Enter the membership type: ");
                        MembershipType = scan.next();
                        A1.Members_of_membership(MembershipType);
                        break; 
                    case 9:
                        System.out.println("Enter Session date: ");
                        SessionDate = scan.next();
                        E1.Members_of_session(SessionDate);
                        break;
                    case 10:
                        A1.ViewMembers_info(auothority.MembersArray);
                        break;
                    default:
                        System.out.println("Enter Number form range (0-10)");
                        break;
                }
            } 
        }
        else if(username.equals("employee") && password.equals("12345")){
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("------- Welcome Employee --------");
            System.out.println("---------------------------------");
            System.out.println("Choose what you want to do:");
            System.out.println("Enter 0 when you are Done");
            System.out.println("1: Add Member");
            System.out.println("2: Edit Member");
            System.out.println("3: Remove Member");
            System.out.println("4: Add Member to Session");
            System.out.println("5: Remove Member from Session");
            System.out.println("6: View members under a specific type of membership");
            System.out.println("7: View any member in a specific session");
            System.out.println("8: View all members info");
            
            while (Done != true){
                System.out.println("---------------------------------");
                System.out.printf("Your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 0:
                        Done = true;
                        scan.close();
                        System.out.println("Saved.");
                        break;
                    case 1:
                        E1.AddMember_System();
                        break;
                    case 2:
                        System.out.println("Enter Member ID: ");
                        Member_Id = scan.nextInt();
                        E1.EditMember_System(Member_Id);
                        break;
                    case 3:
                        System.out.println("Enter Member ID: ");
                        Member_Id = scan.nextInt();
                        E1.RemoveMember_System( Member_Id);
                        break;
                    case 4:
                        isFound = false;
                        System.out.println("Enter Session Date: ");
                        SessionDate = scan.next();
                        System.out.println("Enter MemberID: ");
                        Member_Id = scan.nextInt();
                        for (Member member : auothority.MembersArray) {
                            if(member == null)
                                continue;
                            if(member.SSN == Member_Id){
                                isFound = true;
                                E1.AddMember_Session(SessionDate, member);
                                break;
                            }
                        }
                        if(isFound == false)
                            System.out.println("No Members Found with this ID");
                        break;                        
                    case 5:
                        isFound = false ;
                        System.out.println("Enter Session Date: ");
                        SessionDate = scan.next();
                        System.out.println("Enter MemberID: ");
                        Member_Id = scan.nextInt();
                        for (Member member : auothority.MembersArray) {
                            if(member == null)
                                continue;
                            if(member.SSN == Member_Id){
                                isFound = true;
                                E1.RemoveMember_Session(SessionDate, member);
                                break;
                            }
                        }
                        if(isFound == false)
                            System.out.println("No Member Found with this ID");
                        break;      
                    case 6:
                        System.out.println("Enter the membership type: ");
                        MembershipType = scan.next();
                        E1.Members_of_membership(MembershipType);
                        break; 
                    case 7:
                        System.out.println("Enter Session date: ");
                        SessionDate = scan.next();
                        E1.Members_of_session(SessionDate);
                        break;
                    case 8:
                        E1.ViewMembers_info(auothority.MembersArray);
                        break;
                    default:
                        System.out.println("Enter Number form range (0-8)");
                        break;
                }
            }   
        }
        else
            System.out.println("Wrong credentials");
    }
    } 
}
