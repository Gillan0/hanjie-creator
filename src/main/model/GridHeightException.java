package main.model;

/**
 * Exception used when user tries to reach a line which is not in table
 */
public class GridHeightException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
     * Constructor for GridHeightException.
     *
     * @param message The error message to display when the exception is thrown.
     */
	public GridHeightException(String message) {
		super(message);
	}

}
