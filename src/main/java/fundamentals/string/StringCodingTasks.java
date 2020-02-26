package fundamentals.string;

public class StringCodingTasks {

    public static void main(String[] args) {
        String stringToReverse = "StringToReverse";
        String reversedString = reverseString(stringToReverse);
        System.out.println(stringToReverse);
        System.out.println(reversedString);
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        char swap;
        for (int i = 0; i <= chars.length / 2; i++) {
            swap = chars[i];
            chars[i] = chars[chars.length - (i + 1)];
            chars[chars.length - (i + 1)] = swap;
        }
        return String.valueOf(chars);
    }
}
