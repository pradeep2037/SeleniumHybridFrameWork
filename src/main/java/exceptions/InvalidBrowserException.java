package exceptions;

public class InvalidBrowserException extends RuntimeException {

	public InvalidBrowserException() {
		super("Invalid browser choosen ..make sure use chrome . firfox /edge ..");
	}
}