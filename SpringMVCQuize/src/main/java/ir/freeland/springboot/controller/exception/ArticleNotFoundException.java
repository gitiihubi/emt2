package ir.freeland.springboot.controller.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException() {
        super();
    }

    public ArticleNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ArticleNotFoundException(final String message) {
        super(message);
    }

    public ArticleNotFoundException(final Throwable cause) {
        super(cause);
    }

}
