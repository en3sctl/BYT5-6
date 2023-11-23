package Group1;

//handler interface
interface OperationHandler {
    void setNextHandler(OperationHandler nextHandler);

    void handleRequest(OperationRequest request);
}

//operation request class
class OperationRequest {
    private final String operation;
    private final double operand1;
    private final double operand2;
    private double result;

    public OperationRequest(String operation, double operand1, double operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}

//concrete handler for addition
class AdditionHandler implements OperationHandler {
    private OperationHandler nextHandler;

    @Override
    public void setNextHandler(OperationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(OperationRequest request) {
        if (request.getOperation().equalsIgnoreCase("add")) {
            double result = request.getOperand1() + request.getOperand2();
            request.setResult(result);
            System.out.println("Addition handled: " + result);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

//concrete handler for subtraction
class SubtractionHandler implements OperationHandler {
    private OperationHandler nextHandler;

    @Override
    public void setNextHandler(OperationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(OperationRequest request) {
        if (request.getOperation().equalsIgnoreCase("subtract")) {
            double result = request.getOperand1() - request.getOperand2();
            request.setResult(result);
            System.out.println("Subtraction handled: " + result);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

//concrete handler for multiplication
class MultiplicationHandler implements OperationHandler {
    private OperationHandler nextHandler;

    @Override
    public void setNextHandler(OperationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(OperationRequest request) {
        if (request.getOperation().equalsIgnoreCase("multiply")) {
            double result = request.getOperand1() * request.getOperand2();
            request.setResult(result);
            System.out.println("Multiplication handled: " + result);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

//concrete handler for division
class DivisionHandler implements OperationHandler {
    private OperationHandler nextHandler;

    @Override
    public void setNextHandler(OperationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(OperationRequest request) {
        if (request.getOperation().equalsIgnoreCase("divide")) {
            if (request.getOperand2() != 0) {
                double result = request.getOperand1() / request.getOperand2();
                request.setResult(result);
                System.out.println("Division handled: " + result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    public static void main(String[] args) {
        // Create the chain of responsibility
        OperationHandler additionHandler = new AdditionHandler();
        OperationHandler subtractionHandler = new SubtractionHandler();
        OperationHandler multiplicationHandler = new MultiplicationHandler();
        OperationHandler divisionHandler = new DivisionHandler();

        additionHandler.setNextHandler(subtractionHandler);
        subtractionHandler.setNextHandler(multiplicationHandler);
        multiplicationHandler.setNextHandler(divisionHandler);

        // Create a request
        OperationRequest request1 = new OperationRequest("divide", 10, 2);
        OperationRequest request2 = new OperationRequest("multiply", 10, 2);
        OperationRequest request3 = new OperationRequest("subtract", 10, 2);
        OperationRequest request4 = new OperationRequest("add", 10, 2);

        // Process the request
        additionHandler.handleRequest(request1);
        additionHandler.handleRequest(request2);
        additionHandler.handleRequest(request3);
        additionHandler.handleRequest(request4);
    }
}
