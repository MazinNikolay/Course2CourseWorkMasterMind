package pro.sky.Course2CourseWorkMasterMind.exceptions;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException() {
    }

    public NotAllowedException(String message) {
        super(message);
    }
}
