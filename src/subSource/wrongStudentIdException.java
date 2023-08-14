package subSource;

//StudentId length not 10
public class wrongStudentIdException extends Exception{
	public wrongStudentIdException(String message) {
		super(message);
	}
}
