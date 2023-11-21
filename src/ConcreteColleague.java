public class ConcreteColleague implements Colleague {
    String name;
    Mediator mediator;
    public ConcreteColleague(String name, Mediator mediator){
        this.name = name;
        setMediator(mediator);
    }
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    public String getName(){
        return this.name;
    }
    public void send(String message, Colleague to){
        mediator.send(this, message, to);
    }
    public void send(String message){
        mediator.send(this, message);
    }
    public void receive(String message, Colleague from){
        System.out.println(from.getName() + " to " + getName() + ": " + message);
    }

}
