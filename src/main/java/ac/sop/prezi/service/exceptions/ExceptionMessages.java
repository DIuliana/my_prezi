package ac.sop.prezi.service.exceptions;

public enum ExceptionMessages {

    ROLE_NOT_FOUND_ID("Role not found for id "),
    ROLE_NAME_MANDATORY("Field: name, is mandatory"),
    ROLE_NAME_NOT_FOUND_FOR_ID("Field: name not found for role id "),
    ROLE_FOREIGN_KEY("The Role you are trying to delete has users. Please delete those first and try again. "),
    USER_NOT_FOUND_ID("User not found for id "),
    USER_FIRST_NAME_MANDATORY("Field: firstName, is mandatory"),
    USER_LAST_NAME_MANDATORY("Field: lastName, is mandatory"),
    USER_USER_NAME_MANDATORY("Field: userName, is mandatory"),
    USER_USER_NAME_UNIQ("Field: userName, must be uniq"),
    USER_EMAIL_MANDATORY("Field: email, is mandatory"),
    USER_PASSWORD_MANDATORY("Field: password, is mandatory");

    public String message;

    ExceptionMessages(String s) {
        this.message = s;
    }
}
