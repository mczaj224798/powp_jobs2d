package edu.kis.powp.jobs2d.drivers.factories;

import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.DriverCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {

    public enum Figure {
        RECTANGLE,
        TRIANGLE
    }

    private static class Rectangle {
        public static final int x1 = 200;
        public static final int y1 = 200;

        public static final int x2 = 200;
        public static final int y2 = -200;

        public static final int x3 = -200;
        public static final int y3 = -200;

        public static final int x4 = -200;
        public static final int y4 = 200;

        public static ComplexCommand getCommandList() {
            List<DriverCommand> commandList = new ArrayList<>();
            commandList.add(new SetPositionCommand(x1, y1));
            commandList.add(new OperateToCommand(x1, y1));
            commandList.add(new OperateToCommand(x2, y2));
            commandList.add(new OperateToCommand(x3, y3));
            commandList.add(new OperateToCommand(x4, y4));
            commandList.add(new OperateToCommand(x1, y1));
            return new ComplexCommand(commandList);
        }
    }

    private static class Triangle {
        public static final int x1 = 0;
        public static final int y1 = 100;

        public static final int x2 = 100;
        public static final int y2 = 0;

        public static final int x3 = -100;
        public static final int y3 = 0;


        public static ComplexCommand getCommandList() {
            List<DriverCommand> commandList = new ArrayList<>();
            commandList.add(new SetPositionCommand(x1, y1));
            commandList.add(new OperateToCommand(x1, y1));
            commandList.add(new OperateToCommand(x2, y2));
            commandList.add(new OperateToCommand(x3, y3));
            commandList.add(new OperateToCommand(x1, y1));
            return new ComplexCommand(commandList);
        }
    }

    public static ComplexCommand getFigure(Figure figure) {
        switch (figure) {
            case TRIANGLE:
                return Triangle.getCommandList();
            case RECTANGLE:
                return Rectangle.getCommandList();
            default:
                return null;
        }

    }
}
