package StringCalculator

import java.util.LinkedList
import java.util.Queue

class Calculator private constructor() {
    companion object {
        fun calculate(input: String?): Int {
            checkIsValidExpression(input)
            if (input == null) throw IllegalArgumentException()

            val queue = input.toSequence()
            var result = queue.poll().toInt()

            while (queue.isNotEmpty()) {
                val operator = queue.poll().toOperator()
                val operand = queue.poll().toInt()
                result = operator(result, operand)
            }

            return result
        }

        private fun checkIsValidExpression(input: String?) {
            if (input == null) throw IllegalArgumentException()
            if (input.isBlank()) throw IllegalArgumentException()
            // 공백으로 문자열 분할
            val list = input.split(" ").toMutableList()
            // 빈 문자열 제거
            list.removeIf { element -> element.isEmpty() }
            val queue = input.toSequence()
            // 연산과 수식의 합은 홀수여야 한다.
            if (queue.size % 2 == 0) throw IllegalArgumentException()

            // 수식은 숫자와 연산자가 번갈아 와야 한다.
            var mustBeNumber = false
            while (queue.isNotEmpty()) {
                val parameter = queue.poll()
                mustBeNumber = !mustBeNumber
                if (mustBeNumber && parameter.toIntOrNull() != null) continue
                if (!mustBeNumber && parameter.isValidOperator()) continue
                throw IllegalArgumentException()
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

        fun add(a: Int, b: Int): Int = a + b

        fun subtract(a: Int, b: Int) = a - b

        fun multiply(a: Int, b: Int) = a * b

        fun divide(a: Int, b: Int) = a / b
    }
}
