package com.mars;

import java.util.Scanner;

public class MarsRoverApplication {

    public static void main(String[] args) {
        System.out.println("Enter the upper-right co-ordinates of plateau: ");
        Scanner in = new Scanner(System.in);
        String strCoordinates = in.nextLine();

        System.out.println("Enter the position of the Rover: ");
        String strPosition = in.nextLine();

        System.out.println("Enter the instructions for the rover: ");
        String strInstructions = in.nextLine();

        // TODO: Input validation & loop again for next input
        MarsRoverCommand command = new MarsRoverCommand();
        System.out.println(" Updated Position is: "
                + command.executeInstructions(strCoordinates, strPosition, strInstructions));

    }

}