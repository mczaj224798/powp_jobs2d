package edu.kis.powp.jobs2d.drivers.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand{
   List<DriverCommand> commandList;

    public ComplexCommand(List<DriverCommand> commandList) {
       this.commandList = commandList;
    }

    @Override
    public void execute(Job2dDriver driver) {
        for(DriverCommand command : this.commandList) {
            command.execute(driver);
        }
    }

    public void setCommandList(List<DriverCommand> commandList) {
        this.commandList = commandList;
    }

}
