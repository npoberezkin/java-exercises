package datastructures.stack.exercise;

import java.util.Stack;

public class StackSortWithAnotherStack {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> temp = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(7);
        stack.push(6);
        stack.push(3);
        stack.push(5);
        sortStackWithStack(stack, temp);
        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
    }

    // temp should be sorted in the end
    private static void sortStackWithStack(Stack<Integer> stack, Stack<Integer> temp) {
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            if (!temp.isEmpty() && temp.peek() < cur) {
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
            temp.push(cur);
        }
    }
}
