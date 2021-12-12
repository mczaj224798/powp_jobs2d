package edu.kis.powp.jobs2d.drivers.commands;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    private static class Rectangle {
        public static final int x1 = 2;
        public static final int y1 = 2;

        public static final int x2 = 2;
        public static final int y2 = -2;

        public static final int x3 = -2;
        public static final int y3 = -2;

        public static final int x4 = -2;
        public static final int y4 = 2;

        public static List<DriverCommand> getCommandList() {
            List<DriverCommand> commandList = new ArrayList<>();
            commandList.add(new SetPositionCommand(x1, y1));
            commandList.add(new OperateToCommand(x1, y1));
            commandList.add(new OperateToCommand(x2, y2));
            commandList.add(new OperateToCommand(x3, y3));
            commandList.add(new OperateToCommand(x4, y4));
            commandList.add(new OperateToCommand(x1, y1));
            return commandList;
        }
    }

    private static class Triangle {
        public static final int x1 = 0;
        public static final int y1 = 2;

        public static final int x2 = 2;
        public static final int y2 = 0;

        public static final int x3 = -2;
        public static final int y3 = 0;


        public static List<DriverCommand> getCommandList() {
            List<DriverCommand> commandList = new ArrayList<>();
            commandList.add(new SetPositionCommand(x1, y1));
            commandList.add(new OperateToCommand(x1, y1));
            commandList.add(new OperateToCommand(x2, y2));
            commandList.add(new OperateToCommand(x3, y3));
            commandList.add(new OperateToCommand(x1, y1));
            return commandList;
        }
    }

    public static List<DriverCommand> getRectangle() {
        return Rectangle.getCommandList();
    }

    public static List<DriverCommand> getTriangle() {
        return Triangle.getCommandList();
    }
}
