package application.models;

public enum State {
    DRAFT("draft"),
    RELEASED("released"),
    DELETED("deleted");

    public final String STATE_NAME;

    State(String stateName) {
        STATE_NAME = stateName;
    }
}
