package Week1.Examples;

import java.util.Random;

public class MoneyMover implements Runnable
{
    private int accountA, accountB; // dollar amounts between 0 and 10
    private final int SUM = 10; // total amount of money
    private Random generator;

    private int counter = 0;

    public MoneyMover()
    {  accountA = 5;
        accountB = SUM-accountA;
        generator = new Random();
        Thread threadA = new Thread(this);
        Thread threadB = new Thread(this);
        threadA.start();
        threadB.start();
    }

    public void run()
    {  // should loop forever unless money disappears or appears
        while (isSumCorrect())
        {  // randomly either transfer from A to B or from B to A
            if (generator.nextInt(2)==0)
                transferAToB();
            else
                transferBToA();
        }
        System.out.println("Problem: account A = " + accountA +
                ", account B = " + accountB);
        float percetage = 1/(float) counter;
        System.out.println(percetage);
    }

    // transfer one dollar from account A to account B
    // note this method needs to be synchronized
    private void transferAToB()
    {  System.out.println("Transfering A to B");
        counter++;
        if (accountA>0)
        {  accountA--;
            accountB++;
        }
    }

    // transfer one dollar from account B to account A
    // note this method needs to be synchronized
    private void transferBToA()
    {  System.out.println("Transfering B to A");
        counter++;
        if (accountB>0)
        {  accountB--;
            accountA++;
        }
    }

    // checks whether the total amount is correct
    // note this method needs to be synchronized
    private boolean isSumCorrect()
    {  return (accountA+accountB==SUM);
    }

    public static void main(String[] args)
    {  new MoneyMover();
    }
}

