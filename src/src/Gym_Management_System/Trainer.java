package src.src.Gym_Management_System;

import java.util.Arrays;

public class Trainer extends notAuothority{

    Session[] session = new Session[10];
    Session[] Holds = new Session[10];
    Member[] Supervise = new Member[10];
    int Salary;

    public Trainer(String Name, int SSN, String Sex, String Address, String PhoneNumber, int Salary){
        super(Name, SSN, Sex, Address, PhoneNumber);
        this.Salary = Salary;
    }
    public Trainer(String Name, String Sex, String Address, String PhoneNumber, int Salary, Trainer[] trainers){
        super(Name, Sex, Address, PhoneNumber);
        this.Salary = Salary;
        for (int i = 0; i<trainers.length;i++){
            if(trainers[i] == null){
                SSN = (i+1)+3455;
                break;
            }
        }
    }
    
    @Override
    public String toString(){
        return  "Name: " + Name +
                "\nSSN: "+ SSN +
                "\nSex: "+ Sex + 
                "\nAddress: "+Address+
                "\nSalary: "+Salary+
                "\nPhone Number:" + Arrays.toString(phone);
        
    }
}