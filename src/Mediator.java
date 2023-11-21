public interface Mediator {
    public void send(Colleague from,  String message, Colleague to);
    public void send(Colleague from, String message);
}
