package com.nology;

public class ColourUtils {
	
	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001b[31m";
	public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BRIGHT_GREEN = "\u001b[32;1m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BRIGHT_YELLOW = "\u001b[33;1m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_BRIGHT_BLUE = "\u001B[34;1m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_GREY = "\u001B[37m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BRIGHT_WHITE = "\u001B[38;5;255m";

	public static final String ANSI_RED_BACKGROUND = "\u001b[41;1m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001b[42;1m"; // BRIGHT
	public static final String ANSI_YELLOW_BACKGROUND = "\u001b[48;5;226m"; // BRIGHGT!!
	public static final String ANSI_BLUE_BACKGROUND = "\u001b[44;1m";
	public static final String ANSI_GREY_BACKGROUND = "\u001b[48;5;254m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001b[40m";

	private static boolean useColour = true;
	
	public static boolean isUseColour() {
		return useColour;
	}
	public static void setUseColour(boolean useColour) {
		ColourUtils.useColour = useColour;
	}
	
	public static String blue(Object o) {
		return print(ANSI_BLUE, o);
	}
	public static String blue(Object o, boolean reset) {
		return print(ANSI_BLUE, o, reset);
	}
	public static String brightBlue(Object o, boolean reset) {
		return print(ANSI_BRIGHT_BLUE, o, reset);
	}
	public static String cyan(Object o) {
		return print(ANSI_CYAN, o);
	}
	public static String green(Object o) {
		return print(ANSI_GREEN, o);
	}
	public static String brightGreen(Object o) {
		return print(ANSI_BRIGHT_GREEN, o);
	}
	public static String brightGreen(Object o, boolean reset) {
		return print(ANSI_BRIGHT_GREEN, o, reset);
	}
	public static String grey(Object o) {
		return print(ANSI_GREY, o);
	}
	public static String grey(Object o, boolean reset) {
		return print(ANSI_GREY, o, reset);
	}
	public static String purple(Object o) {
		return print(ANSI_PURPLE, o);
	}
	public static String red(Object o) {
		return print(ANSI_RED, o);
	}
	public static String white(Object o) {
		return print(ANSI_WHITE, o);
	}
	public static String yellow(Object o) {
		return print(ANSI_YELLOW, o);
	}
	public static String brightYellow(Object o) {
		return print(ANSI_BRIGHT_YELLOW, o);
	}
	public static String brightYellow(Object o, boolean reset) {
		return print(ANSI_BRIGHT_YELLOW, o, reset);
	}

	public static String redBg(Object o) {
		return print(ANSI_RED_BACKGROUND, o);
	}
	public static String greenBg(Object o) {
		return print(ANSI_GREEN_BACKGROUND, o);
	}
	public static String yellowBg(Object o) {
		return print(ANSI_YELLOW_BACKGROUND, o);
	}
	public static String blueBg(Object o) {
		return print(ANSI_BLUE_BACKGROUND, o);
	}
	public static String blackBg(Object o) {
		return print(ANSI_BLACK_BACKGROUND, o);
	}
	public static String greyBg(Object o) {
		return print(ANSI_GREY_BACKGROUND, o);
	}

	public static String print(String colour, Object o) {
		return print(colour, o, true);
	}
	public static String print(String colour, Object o, boolean reset) {
		if( o == null ) {
			return "";
		}
		if( (o instanceof String) && ((String)o).equals("") ) {
			return "";
		}
		if( !useColour ) {
			return o.toString();
		}
		return String.format("%s%s%s", colour, o.toString(), reset ? ANSI_RESET : "");
	}

}