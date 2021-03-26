package src.Gym_Management_System;

import java.util.Scanner;

public class Adminstrator extends auothority {

    boolean isFound;
    static Trainer []TrainersArray = new Trainer[10];
    Scanner scan = new Scanner(System.in);

    public Adminstrator(String Name, int Salary, int SSN, String Sex, String Address, String PhoneNumber, String Hire_Date){
        super(Name, SSN, Sex, Address, PhoneNumber, Salary, Hire_Date);

    }



    public void addTrainer_System(){
        String Name;
        String Sex;
        String Address;
        String phoneNumber;
        int Salary;
        Trainer trainer;

        System.out.printf("Please Enter The Trainer Name: ");
        Name = scan.next();
        System.out.printf("male or female: ");
        Sex = scan.next();
        System.out.printf("Address: ");
        Address = scan.next();
        System.out.printf("PhoneNumber: ");
        phoneNumber = scan.next();
        System.out.printf("Salary: ");
        Salary = scan.nextInt();

        trainer = new Trainer(Name, Sex, Address, phoneNumber, Salary,TrainersArray);
        appendValue(TrainersArray, trainer);
        System.out.println("---------------------------------");
        System.out.println(trainer);
        System.out.println("---------------------------------");
        System.out.println("Trainer Added successfully");
        System.out.println("---------------------------------");

        }
    public void editTrainer_System(int TrainerID){
        int choice;
        String Name;
        String Sex;
        String Address;
        String phoneNumber;
        int Salary;
        boolean Done = false;
        isFound = false;
        for (Trainer trainer : TrainersArray) {

            if(trainer == null)
                continue;
            if(trainer.SSN == TrainerID){
                isFound = true;
                System.out.println("--------------------------");
                System.out.println(trainer);
                System.out.println("--------------------------");
                System.out.println("Choose which element would you like to edit:");
                System.out.println("Enter 0 when you are Done");
                System.out.println("1: Name");
                System.out.println("2: Sex");
                System.out.println("3: Address");
                System.out.println("4: PhoneNumber");
                System.out.println("5: Salary");
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
                            trainer.Name = Name;
                            break;
                        case 2:
                            System.out.printf("Enter the new Sex: ");
                            Sex = scan.next();
                            trainer.Sex = Sex;
                            break;
                        case 3:
                            System.out.printf("Enter the new Address: ");
                            Address = scan.next();
                            trainer.Address = Address;
                            break;
                        case 4:
                            System.out.printf("Enter the new PhoneNumber: ");
                            phoneNumber = scan.next();
                            System.out.printf("Enter the index of the phoneNumber(1/2/3): ");
                            int index = scan.nextInt();
                            trainer.phone[index-1] = phoneNumber;
                            break;                        
                        case 5:
                            System.out.printf("Enter the new Salary: ");
                            Salary = scan.nextInt();
                            trainer.Salary = Salary;
                            break;                
                        default:
                            System.out.println("Enter Number form range (0-5)");
                            break;
                    }
                    System.out.println("Edit is saved");
                    System.out.println("---------------------------------");
                }
            }
            if(isFound == true)
            {
                break;
            }
           
        }
          if(isFound==false)
            {
                System.out.println("There is no Trainer with this ID in our System");
            }
    }
    public void RemoveTrainer_System(int TrainerID){
        isFound = false;
        for (Trainer trainer : TrainersArray) {
            if(trainer == null)
                continue;

            if(trainer.SSN == TrainerID){
                isFound = true;
                removeValue(TrainersArray, trainer);
                System.out.println("Trainer is removed successfully");
                break;
            }
            
        }
        if(isFound==false)
            System.out.println("There is no Trainer with this ID in our System");
    }
    public void AddSession(){
        String description;
        String type;
        String date;
        Session session;

        System.out.printf("Enter the Session's description: ");
        description = scan.next();
        System.out.printf("Enter the Session's type: ");
        type = scan.next();
        System.out.printf("Enter the Session's date in format(d/m/y): ");
        date = scan.next();

        session = new Session(description, type, date);
        appendValue(SessionsArray, session);
        System.out.println("Session added successfully");
        System.out.println("---------------------------------");

    }
    public void editSession(String date){
        Boolean Done = false;
        int choice;
        isFound = false;
        for (Session session : SessionsArray) {
            if(session == null)
                continue;

            if(session.date.equals(date)){
                isFound = true;
                System.out.println("---------------------------------");
                System.out.println(session);
                System.out.println("---------------------------------");
                System.out.println("Choose which element would you like to edit:");
                System.out.println("Enter 0 when you are Done");
                System.out.println("1: description");
                System.out.println("2: type");
                System.out.println("3: date");
                while (Done != true){
                    
                    System.out.printf("Your choice: ");
                    choice = scan.nextInt();
                    switch (choice) {
                        case 0:
                            Done = true;
                            System.out.println("Saved.");
                            break;
                        case 1:
                            System.out.printf("Enter the new description: ");
                            String description = scan.next();
                            session.description = description;
                            break;
                        case 2:
                            System.out.printf("Enter the new type: ");
                            String type = scan.next();
                            session.type = type;
                            break;
                        case 3:
                            System.out.printf("Enter the new date: ");
                            String newdate = scan.next();
                            session.date = newdate;
                            break;
                        default:
                            System.out.println("Enter Number form range (0-3)");
                            break;
                    }
                    System.out.println("edit is saved.");
                    System.out.println("---------------------------------");

                }
            } 
            
        }
        if(isFound == false)
            System.out.println("There is no Session in that day");
    }
    public void RemoveSession(String date){
        isFound = false;
        for (Session session : SessionsArray) {
            if(session == null)
                continue;
            if(session.date.equals(date)){
                isFound = true;
                removeValue(SessionsArray, session);
                System.out.println("Session is removed successfully");
            }
        }
        if(isFound==false)
            System.out.println("I couldn't find this Session in our System");
    }
    public int AssginTrainer_Member(){
        int trainer_num    = 0;
        int member_num     = 0;
        int num_of_members = 0;
        isFound = false;

        for (int i =0; i<MembersArray.length ;i++) {
            if(MembersArray[i] == null)
                continue;
            
            else
             {
              isFound = true ;
              System.out.println("Members");
              System.out.println("Name            SSN");
              System.out.println((i+1)+":"+MembersArray[i].Name+"       "+MembersArray[i].SSN);
             }
        }
        if(isFound == true)    
        {    
            isFound = false;
            for (int i =0; i< TrainersArray.length ;i++) 
          {   
              if(TrainersArray[i]==null)
                  continue;
              else
              { 
               isFound = true;
               System.out.println("----------------------------");
               System.out.println("Trainers");
               System.out.println((i+1)+":"+"Name:"+TrainersArray[i].Name+"      SSN:"+TrainersArray[i].SSN);
               System.out.println("----------------------------");
              }
              
          }
             
        }
        else
        { 
            System.out.println("No Members Found ");
            return 0 ;
        }

        System.out.println("Choose the Trainer Number which will be assigned to the members");
        System.out.printf("Trainer Number: ");
        trainer_num = scan.nextInt();
        
        System.out.println("How many Members Do you want to assgin them to the Trainer: "+TrainersArray[trainer_num-1].Name);
        System.out.printf("Number of Members: ");
        num_of_members = scan.nextInt();
        
        System.out.println("Enter the Number of Member you want to assign the Trainer to");
        for(int i = 0 ; i<num_of_members;i++)
        {
            System.out.printf("Member Number: ");
            member_num = scan.nextInt();
            appendValue(TrainersArray[trainer_num-1].Supervise, MembersArray[member_num-1]);
        }
        System.out.println(MembersArray[member_num-1]);
        System.out.println("---------------");
        System.out.println("is assigned to:");
        System.out.println("---------------");
        System.out.println(TrainersArray[trainer_num-1]);
        System.out.println("---------------------------------");
        return 0;

    }
    
}
