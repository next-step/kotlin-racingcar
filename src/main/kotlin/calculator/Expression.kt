package calculator

import java.util.LinkedList
import java.util.Queue

class Expression(
    val input: String
) {

    fun apply(): Queue<String> {
        val sortedPriorityList = priorityIndexes(input)
        return createOperandAndOperatorQueue(input, sortedPriorityList)
    }

    private fun priorityIndexes(data: String): List<Pair<Char, Int>> {
        val priorityList = mutableListOf<Pair<Char, Int>>()

        for (operator in Operator.values()) {
            val index = data.indexOfFirst { c -> operator.equals(c) }
            if (index > -1) {
                val pair: Pair<Char, Int> = Pair(operator.sign, index)
                priorityList.add(pair)
            }
        }

        return priorityList.sortedBy { pair -> pair.second }
    }

    private fun createOperandAndOperatorQueue(data: String, sortedPriorityList: List<Pair<Char, Int>>): Queue<String> {

        var temp = data
        val queue = LinkedList<String>()

        for (pair in sortedPriorityList) {
            val operand = temp.substringBefore(pair.first.toString())
            if (!operand.isNullOrEmpty()) {
                queue.add(operand)
                queue.add(pair.first.toString())
                temp = temp.substringAfter(pair.first.toString())
            }
        }

        queue.add(temp)
        return queue
    }
}
