package me.histal.usercore;

public class Utils {



    public static Short convertStringToShort(String string) {
        try {
            return Short.parseShort(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String stringArrayToString(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg);
        }
        return builder.toString();
    }
}
