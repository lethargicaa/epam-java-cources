package com.epam.university.java.core.task008;

import java.util.Stack;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        Stack<Character> stackOfBraces = new Stack<Character>();
        for (char ch : sourceString.toCharArray()) {
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stackOfBraces.push(ch);
                    break;
                case '}':
                    if (stackOfBraces.empty() || stackOfBraces.pop() != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (stackOfBraces.empty() || stackOfBraces.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stackOfBraces.empty() || stackOfBraces.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stackOfBraces.empty()) {
            return false;
        }
        return true;
    }
}
