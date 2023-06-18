import mathOperation.IMathOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Integer> numbers;
    private List<IMathOperation> mathOperations;
    private Distributor distributor;
    private Calculation calc;


    public Calculator() {
        this.numbers = new ArrayList<Integer>();
        this.mathOperations = new ArrayList<IMathOperation>();
        this.distributor = new Distributor();
        this.calc = new Calculation();
    }

    public void sortUserInput(List<String> inputs) throws Exception{
        mathOperations = distributor.sortMathOperation(inputs);
        numbers = distributor.sortNumbers(inputs);
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
        Calculator calculator = new Calculator();
        calculator.startCalculator();
    }
}

