package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.LineManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class DriverFacade extends AbstractDriver {
    private final DrawPanelController controller;

    public DriverFacade() {
        super(0, 0);
        this.controller = DrawerFeature.getDrawerController();
    }

    @Override
    public void operateTo(int i, int i1) {
            ILine line;
            switch (LineManager.getCurrentLineType()) {
                case SPECIAL:
                    line = LineFactory.getSpecialLine();
                    break;
                case DOTTED:
                    line = LineFactory.getDottedLine();
                    break;
                default:
                    line = LineFactory.getBasicLine();
            }
            line.setStartCoordinates(this.getX(), this.getY());

            line.setEndCoordinates(i, i1);

            this.controller.drawLine(line);
            this.setPosition(i, i1);
    }

    @Override
    public String toString() {
        return "Driver Facade";
    }

}
