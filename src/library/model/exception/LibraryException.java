package library.model.exception;

public class LibraryException extends Exception {
	
	public LibraryException() {}
	
	public LibraryException(Throwable cause) {
		super(cause);
	}
	
	public LibraryException(String message) {
		super(message);
	}
	
	public LibraryException(String message, Throwable cause) {
		super(message, cause);
	}
}
