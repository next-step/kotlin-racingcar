package calculator.common

import java.util.Stack

class OperatorHelper {
    fun infixToPostFix(input: List<String>): MutableList<String> {
        val stack = Stack<String>()
        val postFix = mutableListOf<String>()
        input.forEach {
            if (isNumeric(it)) {
                postFix.add(it)
            } else {
                insertStackToList(postFix, stack)
                stack.add(it)
            }
        }
        insertStackToList(postFix, stack)
        return postFix
    }

    fun isNumeric(str: String) = str.all { it in '0'..'9' }

    fun isOperator(str: String) = str.all { it in charArrayOf('+', '-', '*', '/') }

    private fun insertStackToList(list: MutableList<String>, stack: Stack<String>) {
        while (!stack.isEmpty()) {
            list.add(stack.pop())
        }
    }
}
