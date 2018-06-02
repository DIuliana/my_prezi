package ac.sop.prezi.service.exceptions;

public enum ExceptionMessages {

    ROLE_NOT_FOUND_ID("Role not found for id ");


    public String message;

    ExceptionMessages(String s) {
        this.message = s;
    }
}
