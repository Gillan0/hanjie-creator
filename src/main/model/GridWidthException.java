package main.model;

/**
 * Exception used when user tries to reach a line which is not in table
 */
public class GridWidthException extends Exception {

	/**
     * Constructor for GridWidthException.
     *
     * @param message The error message to display when the exception is thrown.
     */
	public GridWidthException(String message) {
		super(message);
	}
	
}
