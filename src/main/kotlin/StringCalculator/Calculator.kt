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
                val operator = queue.poll().toOperator()
                val operand = queue.poll().toInt()
                result = operator(result, operand)
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
                if (!queue.poll().isValidOperator()) throw IllegalArgumentException()
                if (!queue.poll().isValidOperand()) throw IllegalArgumentException()
            }
        }

        private fun String.toSequence(): Queue<String> {
            return LinkedList(this.split(" ").filter { element -> element.isNotEmpty() })
        }

        private fun String.toOperator(): (Int, Int) -> Int {
            if (this == "+") return Companion::add
            if (this == "-") return Companion::subtract
            if (this == "*") return Companion::multiply
            if (this == "/") return Companion::divide
            throw IllegalArgumentException()
        }

        private fun String.isValidOperator(): Boolean {
            if (this == "-") return true
            if (this == "+") return true
            if (this == "*") return true
            if (this == "/") return true
            return false
        }

        private fun String.isValidOperand(): Boolean = this.toIntOrNull() != null

        fun add(a: Int, b: Int): Int = a + b

        fun subtract(a: Int, b: Int) = a - b

        fun multiply(a: Int, b: Int) = a * b

        fun divide(a: Int, b: Int): Int {
            if (b == 0) throw IllegalArgumentException()
            return a / b
        }
    }
}
