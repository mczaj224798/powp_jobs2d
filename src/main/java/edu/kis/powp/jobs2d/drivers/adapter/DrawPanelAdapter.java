package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.LineManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import javax.sound.sampled.Line;

/**
 * Adapter for DrawPanelController.
 */
public class DrawPanelAdapter implements Job2dDriver {
	private int startX = 0, startY = 0;
	private final DrawPanelController controller;

	public DrawPanelAdapter() {
		this.controller = DrawerFeature.getDrawerController();
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
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
//		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		this.controller.drawLine(line);
		this.setPosition(x, y);
	}

	@Override
	public String toString() {
		return "Normal Line adapter";
	}
}
