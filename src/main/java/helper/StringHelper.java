package helper;

import java.util.Random;

public class StringHelper {

    private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+{}:<>/;";
    private static Random random = new Random();
    public static Character getRandomChar(){
        return chars.charAt(random.nextInt(chars.length()));
    }
}
