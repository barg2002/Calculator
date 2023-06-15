import MathOperation.IMathOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorController {
    private List<Integer> numbers;
    private List<IMathOperation> mathOperations;
    private SortingController sortingController;
    private Calculator calc;


    public CalculatorController() {
        this.numbers = new ArrayList<Integer>();
        this.mathOperations = new ArrayList<IMathOperation>();
        this.sortingController = new SortingController();
        this.calc = new Calculator();
    }

    public void sortUserInput(List<String> inputs) throws Exception{
        mathOperations = sortingController.sortMathOperation(inputs);
        numbers = sortingController.sortNumbers(inputs);
    }

    public void calculator(String input){
        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<String>();
        while(!input.isBlank()){
            inputs.add(input);
            input = sc.nextLine();
        }
        try{
            sortUserInput(inputs);
            System.out.println(calc.calculate(numbers,mathOperations));
        }catch (Exception e){
            System.out.println("wrong input: " + e);
        }
    }

    public void startCalculator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("insert numbers: ");
        String input = sc.nextLine();
        while (input.isBlank()){
            calculator(input);
            input = sc.nextLine();
        }
    }

    public static void main(String[]args){
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.startCalculator();
    }
}

