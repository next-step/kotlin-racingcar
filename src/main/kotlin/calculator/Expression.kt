package calculator

import java.util.LinkedList
import java.util.Queue

class Expression(
    val input: String
) {

    fun apply(): Queue<String> {
        val queue = createOperandAndOperatorQueue(input)
        if (queue.size % 2 == 0) throw IllegalArgumentException()
        return queue
    }

    private fun priorityIndexes(data: String): List<Char> {
        val priorityList = mutableListOf<Char>()

        for (c in data) {
            if (isOperatorLetter(c)) {
                priorityList.add(c)
            }
        }

        return priorityList
    }

    private fun isOperatorLetter(c: Char): Boolean {
        for (operator in Operator.values()) {
            if (operator.isSame(c)) {
                return true
            }
        }
        return false
    }

    private fun createOperandAndOperatorQueue(data: String): Queue<String> {

        var temp = data
        val sortedPriorityList = priorityIndexes(data)
        val queue = LinkedList<String>()

        for (operator in sortedPriorityList) {
            val operand = temp.substringBefore(operator.toString())
            queue.add(operand)
            queue.add(operator.toString())
            temp = temp.substringAfter(operator.toString())
        }

        queue.add(temp)
        return queue
    }
}
