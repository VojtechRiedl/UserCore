package me.histal.usercore;

public class Utils {



    public static Short convertStringToShort(String string) {
        try {
            return Short.parseShort(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
