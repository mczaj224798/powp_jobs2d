package edu.kis.powp.jobs2d.drivers.factories;

import edu.kis.powp.jobs2d.drivers.builders.FigureScript1Builder;
import edu.kis.powp.jobs2d.drivers.builders.FigureScript2Builder;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;

public class FigureScriptFactory {
    public static ComplexCommand getFigureScript1() {
        return (ComplexCommand) (new FigureScript1Builder()).build();
    }

    public static ComplexCommand getFigureScript2() {
        return (ComplexCommand) (new FigureScript2Builder()).build();
    }
}
