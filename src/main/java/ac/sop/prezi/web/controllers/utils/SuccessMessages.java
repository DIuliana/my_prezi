package ac.sop.prezi.web.controllers.utils;

public enum SuccessMessages {

    DELETED_ROLE("Successfully deleted role with id "),
    DELETED_USER("Successfully deleted user with id ");
    public String message;

    SuccessMessages(String s) {
        this.message = s;
    }
}
