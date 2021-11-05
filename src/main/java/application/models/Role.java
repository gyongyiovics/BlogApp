package application.models;

public enum Role {
    ADMIN(Authority.CAN_READ_DATA,
            Authority.CAN_MODIFY_DATA,
            Authority.CAN_READ_NOTE,
            Authority.CAN_DELETE_NOTE,
            Authority.CAN_MODIFY_NOTE,
            Authority.CAN_WRITE_COMMENT),

    MODERATOR(Authority.CAN_WRITE_COMMENT,
            Authority.CAN_MODIFY_NOTE,
            Authority.CAN_DELETE_NOTE,
            Authority.CAN_READ_NOTE),
    //own stuff
    USER_OWN(Authority.CAN_READ_DATA,
            Authority.CAN_MODIFY_DATA,
            Authority.CAN_READ_NOTE,
            Authority.CAN_DELETE_NOTE,
            Authority.CAN_MODIFY_NOTE,
            Authority.CAN_WRITE_COMMENT),

    USER(Authority.CAN_READ_NOTE,
            Authority.CAN_WRITE_COMMENT),

    UNREGISTERED(Authority.CAN_READ_NOTE,
            Authority.CAN_READ_DATA);


    public final Authority[] authorities;

    Role(Authority... authorities) {
        this.authorities = authorities;
    }

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
