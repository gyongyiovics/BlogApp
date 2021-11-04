package application.models;

public enum Authority {
    CAN_READ_DATA,
    CAN_MODIFY_DATA,
    CAN_READ_NOTE,
    CAN_MODIFY_NOTE,
    CAN_DELETE_NOTE,
    CAN_WRITE_COMMENT

    /**
     * enum instead of class :D
     * CAN_READ_DATA, -> admin, user(own), user(notRegistered)
     * CAN_MODIFY_DATA, -> admin, user(own)
     * CAN_READ_NOTE, -> admin, moderator, user(own), user(notOwn), user(notRegistered)
     * CAN_MODIFY_NOTE, -> admin, moderator, user(own)
     * CAN_DELETE_NOTE, -> admin, moderator, user(own)
     * CAN_WRITE_COMMENT -> admin, moderator, user(own), user(notOwn)
     */
}
