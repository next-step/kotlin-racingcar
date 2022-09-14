package StringCalculator

import java.util.LinkedList
import java.util.Queue

class Calculator private constructor() {
    companion object {
        fun calculate(input: String?): Int {
            validateInput(input)

            val queue = input!!.toSequence()
            var result = queue.poll().toInt()

            while (queue.isNotEmpty()) {
                val symbol = queue.poll()
                val operator = CalculatorOperator.values().find { it.symbol == symbol }!!
                val operand = queue.poll().toInt()
                result = operator.calculate(result, operand)
            }

            return result
        }

        private fun validateInput(input: String?) {
            validateIsNotNullOrBlank(input)

            input?.let { validateSequence(it.toSequence()) }
        }

        private fun validateIsNotNullOrBlank(input: String?) {
            if (input.isNullOrBlank()) throw IllegalArgumentException()
        }

        private fun validateSequence(queue: Queue<String>) {
            if (queue.size % 2 == 0) throw IllegalArgumentException()

            if (!queue.poll().isValidOperand()) throw IllegalArgumentException()

            while (queue.isNotEmpty()) {
                val symbol = queue.poll()
                CalculatorOperator.values().find { it.symbol == symbol } ?: throw IllegalArgumentException()
                if (!queue.poll().isValidOperand()) throw IllegalArgumentException()
            }
        }

        private fun String.toSequence(): Queue<String> {
            return LinkedList(this.split(" ").filter { element -> element.isNotEmpty() })
        }

        private fun String.isValidOperand(): Boolean = this.toIntOrNull() != null
    }
}
