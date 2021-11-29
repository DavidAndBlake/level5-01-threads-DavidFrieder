package _02_Advanced_Robot_Race;


import org.jointheleague.graphical.robot.Robot;

import java.util.Random;

public class AdvancedRobotRace
{
    static
    // Re-do the robot race recipe from level 3 module 0.
    // This time, use threads to make all of the robots go at the same time.
    Thread[] threads = new Thread[5];

    public static void main(String[] args)
    {
        Robot[] robots = new Robot[5]; //New robot array called robots

        Random random = new Random();
        for (int k = 0; k < 5; k++)
        {
            robots[k] = new Robot();
            int x = k;
            threads[x] = new Thread(() ->
            {
                robots[x].setX(100 + x * 200);
                robots[x].setY(600);
                    while (robots[x].getY() > 50)
                    {
                        robots[x].setSpeed(random.nextInt(9)+1);
                        robots[x].move(30);
                    }


            });
            int places = 1;
            if(robots[x].getY() <= 50){
            System.out.println("Robot # " + x + " ranks at #" + places);
            places++;
        }
            threads[x].start();
        }
    }
}