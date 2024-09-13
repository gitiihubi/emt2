package ir.freeland.springboot.controller.exception;

public class ArticleMissMatchEception extends RuntimeException {
    public ArticleMissMatchEception() {
        super();
    }

    public ArticleMissMatchEception(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ArticleMissMatchEception(final String message) {
        super(message);
    }

    public ArticleMissMatchEception(final Throwable cause) {
        super(cause);
    }

}
