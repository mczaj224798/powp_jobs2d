package edu.kis.powp.jobs2d.drivers;


// the best approach would be to add abstract method to Job2Driver interface for line options
// and set thee line type but .getCurrentDriver().setLineType(), but the interface is already compiled
// so I've made a workaround with a static class
public class LineManager {
    public enum LineType{
        NORMAL,
        SPECIAL,
        DOTTED
    }

    private static LineType currentLineType = LineType.NORMAL;

    public static void setCurrentLineType(LineType type) {
        LineManager.currentLineType = type;
    }

    public static LineType getCurrentLineType() {
        return LineManager.currentLineType;
    }


}
