package _01_Olympic_Rings;


import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded
{
    // Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.

    public static void main(String[] args)
    {
        Robot[] robots = new Robot[5];
        for (int i = 0; i < 5; i++)
        {
         robots[i] = new Robot();
         robots[i].hide();
        }
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++)
        {
            int x = i;
            robots[i].show();
            threads[i] = new Thread(() ->
            {
                robots[x].setX(200 + x * 200);
                robots[x].penDown();
                System.out.println(x);
                for (int j = 0; j < 360; j++)
                {
                    robots[x].move(1);
                    robots[x].turn(1);
                }
            }
            );
            threads[i].start();
        }
    }

}

