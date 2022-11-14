package calculator.common

import java.util.Stack

class Utils {
    fun infixToPostFix(input: List<String>): MutableList<String> {
        val stack = Stack<String>()
        val postFix = mutableListOf<String>()
        input.forEach {
            if (isNumeric(it)) {
                postFix.add(it)
            } else {
                while (!stack.isEmpty()) {
                    postFix.add(stack.pop())
                }
                stack.add(it)
            }
        }
        while (!stack.isEmpty()) {
            postFix.add(stack.pop())
        }
        return postFix
    }

    fun isNumeric(str: String) = str.all { it in '0'..'9' }

    fun isOperator(str: String) = str.all { it in charArrayOf('+', '-', '*', '/') }
}
