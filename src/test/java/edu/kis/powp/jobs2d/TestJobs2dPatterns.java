package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.LineManager;
import edu.kis.powp.jobs2d.drivers.adapter.DrawPanelAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.DriverFacade;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		ActionListener selectTestFigureOptionListener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				FiguresJoe.figureScript1(DriverFeature.getDriverManager().getCurrentDriver());
			}
		};

		ActionListener selectTestFigureOptionListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				FiguresJoe.figureScript2(DriverFeature.getDriverManager().getCurrentDriver());
			}
		};

		ActionListener selectTestFigureOptionListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				FiguresJane.figureScript((AbstractDriver) DriverFeature.getDriverManager().getCurrentDriver());
			}
		};

		application.addTest("Figure Joe 1", selectTestFigureOptionListener1);
		application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
		application.addTest("Figure Jane", selectTestFigureOptionListener3);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testDriver = new DrawPanelAdapter();
		DriverFeature.addDriver("Normal Line Simulator", testDriver);

		Job2dDriver testDriverDottedLine = new LineDrawerAdapter();
		DriverFeature.addDriver("Special Line Simulator", testDriverDottedLine);

		Job2dDriver testAbstactDriver = new DriverFacade();
		DriverFeature.addDriver("DriverFacade Simulator", testAbstactDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(true);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Setup menu for line options.
	 *
	 * @param application Application context.
	 */
	private static void setupLine(Application application) {
		application.addComponentMenu(LineManager.class, "Line", 0);
		application.addComponentMenuElement(LineManager.class, "Normal",
				(ActionEvent e) -> LineManager.setCurrentLineType(LineManager.LineType.NORMAL));
		application.addComponentMenuElement(LineManager.class, "Dotted",
				(ActionEvent e) -> LineManager.setCurrentLineType(LineManager.LineType.DOTTED));
		application.addComponentMenuElement(LineManager.class, "Special",
				(ActionEvent e) -> LineManager.setCurrentLineType(LineManager.LineType.SPECIAL));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);
				setupLine(app);

				app.setVisibility(true);
			}
		});
	}

}
