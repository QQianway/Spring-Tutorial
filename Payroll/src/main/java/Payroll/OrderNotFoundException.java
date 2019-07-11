package Payroll;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
	OrderNotFoundException(Long id) {
	super("Could not find Order " + id);
}
}
