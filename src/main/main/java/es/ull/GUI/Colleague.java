package java.es.ull.GUI;

public interface Colleague {

    public void setMediator(Mediator mediator);
    public String getName();
    void receive(String message, String from);
    public Mediator getMediator();
}
