package calculator

import java.util.LinkedList
import java.util.Queue

class Expression(
    private var _mathematical: String
) {

    private val mathematical: String
        get() = _mathematical

    init {
        _mathematical = _mathematical.replace(" ", "")
        verifyMathematical(_mathematical)
    }

    fun compute(): Queue<String> {
        return polynomial(mathematical)
    }

    private fun priorityIndexes(data: String): List<Char> {
        return data.filter { c -> isOperatorLetter(c) }.toList()
    }

    private fun isOperatorLetter(c: Char): Boolean {
        return Operator.exist(c)
    }

    private fun polynomial(mathematical: String): Queue<String> {

        var newMathematical = mathematical
        val sortedPriorityList = priorityIndexes(mathematical)
        val queue = LinkedList<String>()

        for (operator in sortedPriorityList) {
            val operand = newMathematical.substringBefore(operator.toString())
            queue.add(operand)
            queue.add(operator.toString())
            newMathematical = newMathematical.substringAfter(operator.toString())
        }

        queue.add(newMathematical)
        if (queue.size % 2 == 0) throw IllegalArgumentException()
        return queue
    }

    private fun verifyMathematical(mathematical: String) {
        val splitData = mathematical.split(*Operator.list().toTypedArray())

        if (splitData.size != mathematical.length - (mathematical.length / 2)) {
            throw IllegalArgumentException()
        }
    }
}
