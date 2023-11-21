import java.util.ArrayList;

public class Chatroom implements Mediator{
    private ArrayList<Colleague> colleagues;

    public Chatroom(){
        colleagues = new ArrayList<Colleague>();
    }

    public void addColleague(Colleague colleague){
        colleagues.add(colleague);
    }

    public void send(Colleague from, String message, Colleague to){
        to.receive(message, from);
    }
    public void send(Colleague from, String message){
        for(Colleague c : colleagues){
            if(c != from){
                c.receive(message, from);
            }
        }
    }
    public ArrayList<Colleague> getColleagues(){
        return colleagues;
    }

}
