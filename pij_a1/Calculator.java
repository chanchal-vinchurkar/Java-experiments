import java.util.Scanner;
public class Calculator
{
    int ch, num1, num2;
    public int addNums(int n1, int n2)
    {
        return n1 + n2;
    }
    public int subtractNums(int n1, int n2)
    {
        return n1 - n2;
    }
    public long multiplyNums(int n1, int n2)
    {
        return (long) n1 * n2;
    }
    public float divNums(int n1, int n2)
    {
        return (float) n1 / n2;
    }
    public int calcMod(int n1, int n2)
    {
        return n1 % n2;
    }
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("\nChoose operation:");
            System.out.println("1.Addition  2.Subtraction  3.Multiplication  4.Division  5.Modulus  0.Exit");
            c.ch = scan.nextInt();
            if (c.ch == 0)
            {
                System.out.println("Exiting...");
                break;
            }
            System.out.println("Enter first number:");
            c.num1 = scan.nextInt();
            System.out.println("Enter second number:");
            c.num2 = scan.nextInt();
            switch (c.ch)
            {
                case 1:
                    System.out.println("Addition: " + c.addNums(c.num1, c.num2));
                    break;
                case 2:
                    System.out.println("Subtraction: " + c.subtractNums(c.num1, c.num2));
                    break;
                case 3:
                    System.out.println("Multiplication: " + c.multiplyNums(c.num1, c.num2));
                    break;
                case 4:
                    if (c.num2 == 0)
                        System.out.println("Division by zero not allowed.");
                    else
                        System.out.println("Division: " + c.divNums(c.num1, c.num2));
                    break;
                case 5:
                    if (c.num2 == 0)
                        System.out.println("Modulus by zero not allowed.");
                    else
                        System.out.println("Modulus: " + c.calcMod(c.num1, c.num2));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }
}
