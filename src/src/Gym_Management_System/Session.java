package src.Gym_Management_System;

public class Session {
    final int num_of_trainers = 1;
    final int num_of_members = 15;
    Member[] members_in_Session = new Member[num_of_members];
    String description;
    String type;
    String date;
    boolean isFound;

    public Session(String description, String type, String date){
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public void display_membersInSession(){
          isFound = false;
        for (Member member : members_in_Session) {
            if(member == null)
                continue;
            if (member != null) 
            {    
                isFound = true;
                System.out.println(member);
            }
        }
        if(isFound == false)
            System.out.println("No Members recorded in this Session");
        
    }
    @Override
    public String toString(){
        return "description: "+description +"   Type: "+type;
    }
}
