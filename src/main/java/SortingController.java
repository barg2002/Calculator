import MathOperation.IMathOperation;
import MathOperation.MathOperationException;
import MathOperation.OperationFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class SortingController {
    private OperationFactory operationFactory;

    public SortingController(){
        operationFactory = new OperationFactory();
    }

    public List<Integer> sortNumbers(List<String> inputs){
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i<inputs.size(); i = i+2) {
            try {
                numbers.add(Integer.parseInt(inputs.get(i)));
            } catch (NumberFormatException e){
                throw new NumberFormatException("The input inserted was not a number.");
            }
            catch (Exception e){
                throw new InputMismatchException("There was a problem with the input.");
            }
        }
        return numbers;
    }

   public List<IMathOperation> sortMathOperation(List<String> inputs) throws MathOperationException {
        List<IMathOperation> mathOperations = new ArrayList<IMathOperation>();
        for (int i = 0; i<inputs.size(); i = i + 2){
            IMathOperation operation = operationFactory.identifyOperations(inputs.get(i));
            if (operation == null){
                throw new MathOperationException("The input entered was not a math operation");
            }
            mathOperations.add(operation);
        }
        return mathOperations;
   }
}
