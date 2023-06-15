import MathOperation.IMathOperation;

import java.util.List;

public class Calculator {
    public int calculate(List<Integer> numbers, List<IMathOperation> operations){
        int sum = numbers.get(0);
        for(int i = 0; i < operations.size(); i++){
            sum = operations.get(i).calculate(numbers.get(i + 1), sum);
        }
        return sum;
    }
}
