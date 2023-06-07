package stringcalculator

import java.util.LinkedList
import java.util.Queue


object StringCalculator {
    fun calculate(input: String): Number {
        val splitInput = input.split(" ").map { it.trim() }
        val operands = extractOperands(splitInput)
        val operators = extractOperators(splitInput)
        var summery: Number = operands.poll()

        for (operand in operands) {
            val operator = operators.poll()

            summery = operator.operate(summery, operand)
        }


        return summery
    }

    private fun extractOperands(splitInput: List<String>): Queue<Number> {
        val queue = LinkedList<Number>()

        splitInput.indices
            .filter { it % 2 == 0 }
            .forEach { queue.add(Number(splitInput[it])) }

        return queue
    }

    private fun extractOperators(splitInput: List<String>): Queue<Operator> {
        val queue = LinkedList<Operator>()

        splitInput.indices
            .filter { it % 2 == 1 }
            .forEach { queue.add(Operator.findBySymbol(splitInput[it])) }

        return queue
    }
}
