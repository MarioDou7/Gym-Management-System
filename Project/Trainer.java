package Project;

import java.util.Arrays;

public class Trainer extends notAuothority{

    Session[] session;
    Session[] Holds;
    Member [] Supervise;
    int Salary;

    public Trainer(String Name, int SSN, String Sex, String Address, int PhoneNumber, int Salary){
        super(Name, SSN, Sex, Address, PhoneNumber);
        this.Salary = Salary;
    }
    public Trainer(String Name, String Sex, String Address, int PhoneNumber, int Salary, Trainer[] trainers){
        super(Name, Sex, Address, PhoneNumber);
        this.Salary = Salary;
        for (int i = 0; i<trainers.length;i++){
            if(trainers[i] == null){
                SSN = i;
                break;
            }
        }
    }
    
    public String toString(){
        return  "Name: "+ Name +
                "\nSex: "+ Sex + 
                "\nAddress: "+Address+
                "\nSalary: "+Salary+
                "\nPhone Number:" + Arrays.toString(phone);
        
    }
}