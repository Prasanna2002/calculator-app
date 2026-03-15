package com.calc;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Calculator {
    public static void main(String[] args)
    {

        Calculator c=new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Choose to perform operation");
            System.out.print("Type 1 to find Square root\nType 2 to find  Factorial\nType 3 to find power\nType 4 to find natural logarithm\n" +
                    "\nType any other digit to exit\nEnter the type of operation: ");
            int ch;

            try {
                ch = scanner.nextInt();
            } catch (InputMismatchException error) {
                scanner.close();
                return;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + c.sqroot(number1));
                    System.out.println("\n");


                    break;
                case 2:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + c.fact(number1));
                    System.out.println("\n");


                    break;
                case 3:
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + c.power(number1, number2));
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + c.naturalLog(number1));
                    System.out.println("\n");
                    break;

                // case 5:
                //     System.out.println("Enter a number:"); 
                //     number1 = scanner.nextDouble(); 
                //     System.out.println("Result of multiplying the number by itself is "+c.power(number1,number1)); 
                //     break;
                default:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
            }
        } while (true);
    }


    public double fact(double number1) {
        if(number1<0)
        {
            return Double.NaN;
        }
        double fact=1;
        for(int i=2;i<=number1;i++)
            fact=fact*i;
        return fact;
    }



    public double sqroot(double number1) {
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0");
            }
            else {
                result = Math.sqrt(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        return result;
    }


    public double power(double number1, double number2) {
        double result = Math.pow(number1,number2);
        return result;
    }

    public double naturalLog(double number1) {
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        return result;
    }
}