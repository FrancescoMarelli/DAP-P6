public class ConcreteColleague implements Colleague {
    String name;
    Mediator chatWindow;
    public ConcreteColleague(String name){
        this.name = name;
    }
    public void setMediator(Mediator mediator) {
        this.chatWindow = mediator;
    }
    public Mediator getMediator() { return chatWindow; }
    public String getName(){
        return this.name;
    }
    public void receive(String message, String from){
        chatWindow.displayMessage(from, message);
    }


}
