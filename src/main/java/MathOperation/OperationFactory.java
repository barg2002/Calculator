package MathOperation;

public class OperationFactory {
    public IMathOperation identifyOperations(String input){
        char operation = input.strip().charAt(0);
        switch (operation){
            case '+':
                return new Addition();
            case '-':
                return new Substraction();
            case '/':
                return new Division();
            case '*':
                return new Multiplication();
            default:
                return null;
        }
    }
}
