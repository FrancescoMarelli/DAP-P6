public interface Colleague {

    public void setMediator(Mediator mediator);
    public String getName();
    void send(String message, Colleague to);
    void receive(String message, Colleague from);
}
