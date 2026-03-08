package com.calc;

import java.util.Scanner;

public class Calculator {
    // Let's Do this
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        do{
            System.out.println("\n----- Scientific Calculator------\n");
            System.out.println("1. Square Root\n2. Factorial\n3. Natural Log (ln)\n4. Power Function");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double a = scanner.nextDouble();
                    System.out.println("Result: " + Math.sqrt(a));
                    break;
                case 2:
                    System.out.print("Enter integer: ");
                    int num = scanner.nextInt();
                    System.out.println("Result: " + factorial(num));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + Math.log(b));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(base, exp));
                    break;
                default: 
                    System.out.println("Exiting....\n"); 
                    condition = false;
                    scanner.close();
                    break; 
            }
        } while (condition == true); 
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}