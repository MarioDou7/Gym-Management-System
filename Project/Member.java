package Project;

import java.util.Arrays;

public class Member extends notAuothority{
    String MemberShip;
    Double weight;
    
    public Member(String Name, int SSN, String Sex, String Address, String PhoneNumber, String memberShip, Double weight){
        super(Name, SSN, Sex, Address, PhoneNumber);
        this.MemberShip = memberShip;
        this.weight = weight;
    }
    public Member(String Name, String Sex, String Address, String PhoneNumber, String memberShip, Double weight,Member []members){
        super(Name, Sex, Address, PhoneNumber);
        this.MemberShip = memberShip;
        this.weight = weight;
        for (int i = 0; i<members.length;i++){
            if(members[i] == null){
                SSN = i;
                break;
            }
        }
    }
    

    public String toString(){
        return "------------------"+
                "\nName:        "+ Name+
                "\nSSN:         "+ SSN+
                "\nSex:         "+ Sex+
                "\nAddress:     "+ Address+
                "\nMemberShip:  "+ MemberShip+
                "\nPhoneNumbers:"+Arrays.toString(phone)+        
                "\nweight: "+weight;
    }
}
