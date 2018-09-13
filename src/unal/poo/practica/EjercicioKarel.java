/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Estudiante
 */
import becker.robots.*;
import java.awt.Color;
import java.util.Scanner;
import becker.robots.Direction;

public class EjercicioKarel {

    private City ciudad;
    private Robot robot;
   
    public double totali;
    int[][] city = new int[10][10];

    public EjercicioKarel() {

        Scanner leer = new Scanner(System.in);
        this.ciudad = new City();
        for (int i = 1; i <= 10; i++) {
            Wall pared = new Wall(ciudad, 1, i, Direction.NORTH);
        }
        for (int i = 1; i <= 10; i++) {
            Wall pared = new Wall(ciudad, i, 1, Direction.WEST);
        }
        for (int i = 1; i <= 10; i++) {
            Wall pared = new Wall(ciudad, 10, i, Direction.SOUTH);
        }
        for (int i = 1; i <= 10; i++) {
            Wall pared = new Wall(ciudad, i, 10, Direction.EAST);
        }
        for (int i = 4; i < 7; i++) {
            Wall pared = new Wall(ciudad, 7, i, Direction.SOUTH);
        }
        for (int i = 5; i < 8; i++) {
            Wall pared = new Wall(ciudad, i, 6, Direction.EAST);
        }

        Wall pared1 = new Wall(ciudad, 5, 6, Direction.NORTH);
        Wall pared3 = new Wall(ciudad, 7, 4, Direction.WEST);
        Wall pared4 = new Wall(ciudad, 5, 6, Direction.WEST);
        Wall pared5 = new Wall(ciudad, 6, 5, Direction.NORTH);
        Wall pared6 = new Wall(ciudad, 7, 4, Direction.NORTH);
        Wall pared7 = new Wall(ciudad, 6, 5, Direction.NORTH);
        Wall pared8 = new Wall(ciudad, 6, 5, Direction.WEST);
        Thing b = new Thing(ciudad, 8, 4);

        robot = new Robot(ciudad, 8, 4, Direction.WEST);

        do {
            girard();
            if (robot.frontIsClear() == false) {
                city[robot.getAvenue()][robot.getStreet()] = 1;
            }
            if (robot.frontIsClear() == false) {

                robot.turnLeft();
                if (robot.frontIsClear()) {
                    robot.move();
                } else {
                    robot.turnLeft();
                    robot.move();
                }
            } else {
                robot.move();
            }

        } while (robot.canPickThing() == false);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(city[i][j]);
                System.out.print(" ");

            }
            System.out.println();

        }
        System.out.println();
        contar();
    }

    public void girard() {
        for (int i = 0; i < 3; i++) {
            robot.turnLeft();
        }
    }

    public void contar() {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (city[i][j] == 1) {
                    int sub = 0;
                    while(j<9 && city[i][++j] == 0){
                        sub = sub + 1;
                    }
                    if (city[i][j] == 1)
                        a += sub;
                }
            }
        }
        System.out.println("El area de la figura es "+ a );
    }
    
}
