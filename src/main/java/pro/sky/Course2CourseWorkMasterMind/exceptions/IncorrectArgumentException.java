package pro.sky.Course2CourseWorkMasterMind.exceptions;

public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(String message) {
        super(message);
    }

    public IncorrectArgumentException() {
    }
}
