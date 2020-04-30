package datastructures.stack;

import java.util.Stack;

public class BracketSeqChecker {

    public static void main(String[] args) {
        System.out.println(checkBracketsSeq("[{}]"));
        System.out.println(checkBracketsSeq("(()())"));
        System.out.println(checkBracketsSeq("{]"));
        System.out.println(checkBracketsSeq("[{}]))()"));
        System.out.println(checkBracketsSeq("[]{}({})"));
    }

    private static boolean checkBracketsSeq(String string) {
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ((ch == '{') || (ch == '[') || (ch == '(')) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character poped = stack.pop();
                    if (!isReverseBrackets(poped, ch)) {
                        return false;
                    }
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

    private static boolean isReverseBrackets(char opening, char closing) {
        if ((opening == '{' && closing == '}')
                || (opening == '[' && closing == ']')
                || (opening == '(' && closing == ')')) {
            return true;
        }
        return false;
    }
}
