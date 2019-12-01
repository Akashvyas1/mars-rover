package com.mars;

import com.mars.data.Surroundings;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MarsRoverCommand {

    private static Map<String, Point> directionToMovement = new HashMap<>();
    private static Map<String, Surroundings> directionToSurrounding = new HashMap<>();

    static {
        directionToMovement.put("N", new Point(0,1));
        directionToMovement.put("E", new Point(1,0));
        directionToMovement.put("S", new Point(0,-1));
        directionToMovement.put("W", new Point(-1,0));

        directionToSurrounding.put("N", new Surroundings("W", "E"));
        directionToSurrounding.put("E", new Surroundings("N", "S"));
        directionToSurrounding.put("S", new Surroundings("E", "W"));
        directionToSurrounding.put("W", new Surroundings("S", "N"));
    }

    public String executeInstructions(String plateauCoordinates, String strRoverPosition, String instructions) {
        Point roverPosition = new Point(Character.getNumericValue(strRoverPosition.charAt(0)),
                Character.getNumericValue(strRoverPosition.charAt(1)));
        String direction = Character.toString(strRoverPosition.charAt(2));

        for (char c:instructions.toCharArray()) {
            if ('M' == c) {
                int dx = (int) directionToMovement.get(direction).getX();
                int dy = (int) directionToMovement.get(direction).getY();
                roverPosition.translate(dx, dy);
            } else if ('L' == c) {
                direction = directionToSurrounding.get(direction).getLeft();
            } else {
                direction = directionToSurrounding.get(direction).getRight();
            }
        }

        return String.valueOf((int) roverPosition.getX()) + String.valueOf((int) roverPosition.getY()) + direction;
    }
}
