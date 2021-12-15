package edu.kis.powp.jobs2d.drivers.builders;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.DriverCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.util.ArrayList;
import java.util.List;

public class FigureScript2Builder implements Job2dDriver, Builder{
    private final List<DriverCommand> commandList = new ArrayList<>();

    @Override
    public void setPosition(int x, int y) {
        this.commandList.add(new SetPositionCommand(x, y));
    }

    @Override
    public void operateTo(int x, int y) {
        this.commandList.add(new OperateToCommand(x, y));
    }

    @Override
    public Object build() {
        if (this.commandList.size() == 0) {
            /* we could have also used another class for implementing Job2Driver (adapter)
               but I believe this solution is more elegant as this builder has very specialized functionality */
            FiguresJoe.figureScript2(this);
        }
        return new ComplexCommand(this.commandList);
    }
}
